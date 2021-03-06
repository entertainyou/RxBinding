package com.jakewharton.rxbinding.widget;

import android.support.annotation.CheckResult;
import android.widget.ProgressBar;
import rx.functions.Action1;

public final class RxProgressBar {
  /**
   * An action which increments the progress value of {@code view}.
   * <p>
   * <em>Warning:</em> The created observable keeps a strong reference to {@code view}. Unsubscribe
   * to free this reference.
   */
  @CheckResult
  public static Action1<? super Integer> incrementProgressBy(final ProgressBar view) {
    return new Action1<Integer>() {
      @Override public void call(Integer value) {
        view.incrementProgressBy(value);
      }
    };
  }

  /**
   * An action which increments the secondary progress value of {@code view}.
   * <p>
   * <em>Warning:</em> The created observable keeps a strong reference to {@code view}. Unsubscribe
   * to free this reference.
   */
  @CheckResult
  public static Action1<? super Integer> incrementSecondaryProgressBy(final ProgressBar view) {
    return new Action1<Integer>() {
      @Override public void call(Integer value) {
        view.incrementSecondaryProgressBy(value);
      }
    };
  }

  /**
   * An action which sets whether {@code view} is indeterminate.
   * <p>
   * <em>Warning:</em> The created observable keeps a strong reference to {@code view}. Unsubscribe
   * to free this reference.
   */
  @CheckResult
  public static Action1<? super Boolean> indeterminate(final ProgressBar view) {
    return new Action1<Boolean>() {
      @Override public void call(Boolean value) {
        view.setIndeterminate(value);
      }
    };
  }

  /**
   * An action which sets the max value of {@code view}.
   * <p>
   * <em>Warning:</em> The created observable keeps a strong reference to {@code view}. Unsubscribe
   * to free this reference.
   */
  @CheckResult
  public static Action1<? super Integer> max(final ProgressBar view) {
    return new Action1<Integer>() {
      @Override public void call(Integer value) {
        view.setMax(value);
      }
    };
  }

  /**
   * An action which sets the progress value of {@code view}.
   * <p>
   * <em>Warning:</em> The created observable keeps a strong reference to {@code view}. Unsubscribe
   * to free this reference.
   */
  @CheckResult
  public static Action1<? super Integer> progress(final ProgressBar view) {
    return new Action1<Integer>() {
      @Override public void call(Integer value) {
        view.setProgress(value);
      }
    };
  }

  /**
   * An action which sets the secondary progress value of {@code view}.
   * <p>
   * <em>Warning:</em> The created observable keeps a strong reference to {@code view}. Unsubscribe
   * to free this reference.
   */
  @CheckResult
  public static Action1<? super Integer> secondaryProgress(final ProgressBar view) {
    return new Action1<Integer>() {
      @Override public void call(Integer value) {
        view.setSecondaryProgress(value);
      }
    };
  }
}
