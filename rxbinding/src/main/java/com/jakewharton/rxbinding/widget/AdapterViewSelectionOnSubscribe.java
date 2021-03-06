package com.jakewharton.rxbinding.widget;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding.internal.MainThreadSubscription;
import rx.Observable;
import rx.Subscriber;

import static android.widget.AdapterView.INVALID_POSITION;
import static com.jakewharton.rxbinding.internal.Preconditions.checkUiThread;

final class AdapterViewSelectionOnSubscribe
    implements Observable.OnSubscribe<AdapterViewSelectionEvent> {
  private final AdapterView<?> view;

  public AdapterViewSelectionOnSubscribe(AdapterView<?> view) {
    this.view = view;
  }

  @Override public void call(final Subscriber<? super AdapterViewSelectionEvent> subscriber) {
    checkUiThread();

    AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (!subscriber.isUnsubscribed()) {
          subscriber.onNext(AdapterViewItemSelectionEvent.create(parent, view, position, id));
        }
      }

      @Override public void onNothingSelected(AdapterView<?> parent) {
        if (!subscriber.isUnsubscribed()) {
          subscriber.onNext(AdapterViewNothingSelectionEvent.create(parent));
        }
      }
    };

    subscriber.add(new MainThreadSubscription() {
      @Override protected void onUnsubscribe() {
        view.setOnItemSelectedListener(null);
      }
    });

    view.setOnItemSelectedListener(listener);

    // Emit initial value.
    int selectedPosition = view.getSelectedItemPosition();
    if (selectedPosition == INVALID_POSITION) {
      subscriber.onNext(AdapterViewNothingSelectionEvent.create(view));
    } else {
      View selectedView = view.getSelectedView();
      long selectedId = view.getSelectedItemId();
      subscriber.onNext(
          AdapterViewItemSelectionEvent.create(view, selectedView, selectedPosition, selectedId));
    }
  }
}
