package com.jakewharton.rxbinding.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import static com.jakewharton.rxbinding.internal.Preconditions.checkNotNull;

/**
 * A timestamp and target view on which an event occurred (e.g., click).
 * <p>
 * <strong>Warning:</strong> Instances keep a strong reference to the view. Operators that cache
 * instances have the potential to leak the associated {@link Context}.
 */
public abstract class ViewEvent<T extends View> {
  @NonNull private final T view;

  protected ViewEvent(@NonNull T view) {
    this.view = checkNotNull(view, "view == null");
  }

  /** The view from which this event occurred. */
  public @NonNull T view() {
    return view;
  }
}
