package com.jakewharton.rxbinding.widget;

import android.content.Context;
import android.widget.TextView;
import com.jakewharton.rxbinding.view.ViewEvent;

import static com.jakewharton.rxbinding.internal.Preconditions.checkNotNull;

/**
 * A text-change event on a view.
 * <p>
 * <strong>Warning:</strong> Instances keep a strong reference to the view. Operators that cache
 * instances have the potential to leak the associated {@link Context}.
 */
public final class TextViewTextChangeEvent extends ViewEvent<TextView> {
  public static TextViewTextChangeEvent create(TextView view, CharSequence text, int start,
      int before, int count) {
    return new TextViewTextChangeEvent(view, text, start, before, count);
  }

  private final CharSequence text;
  private final int start;
  private final int before;
  private final int count;

  private TextViewTextChangeEvent(TextView view, CharSequence text, int start, int before,
      int count) {
    super(view);
    this.text = checkNotNull(text, "text == null");
    this.start = start;
    this.before = before;
    this.count = count;
  }

  public CharSequence text() {
    return text;
  }

  public int start() {
    return start;
  }

  public int before() {
    return before;
  }

  public int count() {
    return count;
  }

  @Override public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof TextViewTextChangeEvent)) return false;
    TextViewTextChangeEvent other = (TextViewTextChangeEvent) o;
    return other.view() == view()
        && text.equals(other.text)
        && start == other.start
        && before == other.before
        && count == other.count;
  }

  @Override public int hashCode() {
    int result = 17;
    result = result * 37 + view().hashCode();
    result = result * 37 + text.hashCode();
    result = result * 37 + start;
    result = result * 37 + before;
    result = result * 37 + count;
    return result;
  }

  @Override public String toString() {
    return "TextViewTextChangeEvent{text="
        + text
        + ", start="
        + start
        + ", before="
        + before
        + ", count="
        + count
        + ", view="
        + view()
        + '}';
  }
}
