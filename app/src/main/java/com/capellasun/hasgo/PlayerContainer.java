package com.capellasun.hasgo;

/*
    XML TEMPLATE

    <android.support.constraint.ConstraintLayout
                        android:layout_width="match_parent"
                        android:layout_height="match_parent">

                        <ImageView
                            android:id="@+id/imageView"
                            android:layout_width="60dp"
                            android:layout_height="match_parent"
                            android:layout_marginBottom="8dp"
                            android:layout_marginStart="8dp"
                            android:layout_marginTop="8dp"
                            android:layout_weight="1"
                            app:layout_constraintBottom_toBottomOf="parent"
                            app:layout_constraintStart_toStartOf="parent"
                            app:layout_constraintTop_toTopOf="parent"
                            app:srcCompat="@android:drawable/ic_lock_idle_low_battery" />

                        <TextView
                            android:id="@+id/textView6"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_marginBottom="8dp"
                            android:layout_marginEnd="152dp"
                            android:layout_marginStart="8dp"
                            android:layout_marginTop="8dp"
                            android:layout_weight="1"
                            android:text="Seeker"
                            android:textAppearance="@style/TextAppearance.AppCompat.Headline"
                            app:layout_constraintBottom_toBottomOf="parent"
                            app:layout_constraintEnd_toEndOf="parent"
                            app:layout_constraintHorizontal_bias="0.088"
                            app:layout_constraintStart_toEndOf="@+id/imageView"
                            app:layout_constraintTop_toTopOf="parent"
                            app:layout_constraintVertical_bias="0.0" />

                        <ImageView
                            android:id="@+id/imageView2"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_marginBottom="8dp"
                            android:layout_marginEnd="8dp"
                            android:layout_marginStart="8dp"
                            android:layout_marginTop="8dp"
                            app:layout_constraintBottom_toBottomOf="parent"
                            app:layout_constraintEnd_toEndOf="parent"
                            app:layout_constraintHorizontal_bias="0.942"
                            app:layout_constraintStart_toEndOf="@+id/textView6"
                            app:layout_constraintTop_toTopOf="parent"
                            app:srcCompat="@android:drawable/btn_dialog" />

                    </android.support.constraint.ConstraintLayout>
     */

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;

public class PlayerContainer extends ConstraintLayout{

    public PlayerContainer(Context context) {
        super(context);
    }

    public PlayerContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PlayerContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
