// Generated by view binder compiler. Do not edit!
package com.example.readme.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.readme.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCreateBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView bookAuthorTextView;

  @NonNull
  public final TextView bookAuthorTextView2;

  @NonNull
  public final EditText bookClubNameEditText;

  @NonNull
  public final ImageView bookImageView;

  @NonNull
  public final TextView bookTitleTextView;

  @NonNull
  public final EditText descriptionEditText;

  @NonNull
  public final GridLayout gridLayout;

  @NonNull
  public final TextView meetWhere;

  @NonNull
  public final EditText participantsEditText;

  @NonNull
  public final TextView placeBusan;

  @NonNull
  public final TextView placeChungbuk;

  @NonNull
  public final TextView placeChungnam;

  @NonNull
  public final TextView placeDaegu;

  @NonNull
  public final TextView placeDaejeon;

  @NonNull
  public final TextView placeGangwon;

  @NonNull
  public final TextView placeGwangju;

  @NonNull
  public final TextView placeGyeongbuk;

  @NonNull
  public final TextView placeGyeonggi;

  @NonNull
  public final TextView placeGyeongnam;

  @NonNull
  public final TextView placeIncheon;

  @NonNull
  public final TextView placeJeju;

  @NonNull
  public final TextView placeJeonbuk;

  @NonNull
  public final TextView placeJeonnam;

  @NonNull
  public final TextView placeSejong;

  @NonNull
  public final TextView placeSeoul;

  @NonNull
  public final TextView placeUlsan;

  @NonNull
  public final EditText tagsEditText;

  @NonNull
  public final TextView titleTextView;

  @NonNull
  public final Button updateButton;

  private ActivityCreateBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView bookAuthorTextView, @NonNull TextView bookAuthorTextView2,
      @NonNull EditText bookClubNameEditText, @NonNull ImageView bookImageView,
      @NonNull TextView bookTitleTextView, @NonNull EditText descriptionEditText,
      @NonNull GridLayout gridLayout, @NonNull TextView meetWhere,
      @NonNull EditText participantsEditText, @NonNull TextView placeBusan,
      @NonNull TextView placeChungbuk, @NonNull TextView placeChungnam,
      @NonNull TextView placeDaegu, @NonNull TextView placeDaejeon, @NonNull TextView placeGangwon,
      @NonNull TextView placeGwangju, @NonNull TextView placeGyeongbuk,
      @NonNull TextView placeGyeonggi, @NonNull TextView placeGyeongnam,
      @NonNull TextView placeIncheon, @NonNull TextView placeJeju, @NonNull TextView placeJeonbuk,
      @NonNull TextView placeJeonnam, @NonNull TextView placeSejong, @NonNull TextView placeSeoul,
      @NonNull TextView placeUlsan, @NonNull EditText tagsEditText, @NonNull TextView titleTextView,
      @NonNull Button updateButton) {
    this.rootView = rootView;
    this.bookAuthorTextView = bookAuthorTextView;
    this.bookAuthorTextView2 = bookAuthorTextView2;
    this.bookClubNameEditText = bookClubNameEditText;
    this.bookImageView = bookImageView;
    this.bookTitleTextView = bookTitleTextView;
    this.descriptionEditText = descriptionEditText;
    this.gridLayout = gridLayout;
    this.meetWhere = meetWhere;
    this.participantsEditText = participantsEditText;
    this.placeBusan = placeBusan;
    this.placeChungbuk = placeChungbuk;
    this.placeChungnam = placeChungnam;
    this.placeDaegu = placeDaegu;
    this.placeDaejeon = placeDaejeon;
    this.placeGangwon = placeGangwon;
    this.placeGwangju = placeGwangju;
    this.placeGyeongbuk = placeGyeongbuk;
    this.placeGyeonggi = placeGyeonggi;
    this.placeGyeongnam = placeGyeongnam;
    this.placeIncheon = placeIncheon;
    this.placeJeju = placeJeju;
    this.placeJeonbuk = placeJeonbuk;
    this.placeJeonnam = placeJeonnam;
    this.placeSejong = placeSejong;
    this.placeSeoul = placeSeoul;
    this.placeUlsan = placeUlsan;
    this.tagsEditText = tagsEditText;
    this.titleTextView = titleTextView;
    this.updateButton = updateButton;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCreateBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCreateBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_create, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCreateBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bookAuthorTextView;
      TextView bookAuthorTextView = ViewBindings.findChildViewById(rootView, id);
      if (bookAuthorTextView == null) {
        break missingId;
      }

      id = R.id.bookAuthorTextView2;
      TextView bookAuthorTextView2 = ViewBindings.findChildViewById(rootView, id);
      if (bookAuthorTextView2 == null) {
        break missingId;
      }

      id = R.id.bookClubNameEditText;
      EditText bookClubNameEditText = ViewBindings.findChildViewById(rootView, id);
      if (bookClubNameEditText == null) {
        break missingId;
      }

      id = R.id.bookImageView;
      ImageView bookImageView = ViewBindings.findChildViewById(rootView, id);
      if (bookImageView == null) {
        break missingId;
      }

      id = R.id.bookTitleTextView;
      TextView bookTitleTextView = ViewBindings.findChildViewById(rootView, id);
      if (bookTitleTextView == null) {
        break missingId;
      }

      id = R.id.descriptionEditText;
      EditText descriptionEditText = ViewBindings.findChildViewById(rootView, id);
      if (descriptionEditText == null) {
        break missingId;
      }

      id = R.id.grid_layout;
      GridLayout gridLayout = ViewBindings.findChildViewById(rootView, id);
      if (gridLayout == null) {
        break missingId;
      }

      id = R.id.meet_where;
      TextView meetWhere = ViewBindings.findChildViewById(rootView, id);
      if (meetWhere == null) {
        break missingId;
      }

      id = R.id.participantsEditText;
      EditText participantsEditText = ViewBindings.findChildViewById(rootView, id);
      if (participantsEditText == null) {
        break missingId;
      }

      id = R.id.place_busan;
      TextView placeBusan = ViewBindings.findChildViewById(rootView, id);
      if (placeBusan == null) {
        break missingId;
      }

      id = R.id.place_chungbuk;
      TextView placeChungbuk = ViewBindings.findChildViewById(rootView, id);
      if (placeChungbuk == null) {
        break missingId;
      }

      id = R.id.place_chungnam;
      TextView placeChungnam = ViewBindings.findChildViewById(rootView, id);
      if (placeChungnam == null) {
        break missingId;
      }

      id = R.id.place_daegu;
      TextView placeDaegu = ViewBindings.findChildViewById(rootView, id);
      if (placeDaegu == null) {
        break missingId;
      }

      id = R.id.place_daejeon;
      TextView placeDaejeon = ViewBindings.findChildViewById(rootView, id);
      if (placeDaejeon == null) {
        break missingId;
      }

      id = R.id.place_gangwon;
      TextView placeGangwon = ViewBindings.findChildViewById(rootView, id);
      if (placeGangwon == null) {
        break missingId;
      }

      id = R.id.place_gwangju;
      TextView placeGwangju = ViewBindings.findChildViewById(rootView, id);
      if (placeGwangju == null) {
        break missingId;
      }

      id = R.id.place_gyeongbuk;
      TextView placeGyeongbuk = ViewBindings.findChildViewById(rootView, id);
      if (placeGyeongbuk == null) {
        break missingId;
      }

      id = R.id.place_gyeonggi;
      TextView placeGyeonggi = ViewBindings.findChildViewById(rootView, id);
      if (placeGyeonggi == null) {
        break missingId;
      }

      id = R.id.place_gyeongnam;
      TextView placeGyeongnam = ViewBindings.findChildViewById(rootView, id);
      if (placeGyeongnam == null) {
        break missingId;
      }

      id = R.id.place_incheon;
      TextView placeIncheon = ViewBindings.findChildViewById(rootView, id);
      if (placeIncheon == null) {
        break missingId;
      }

      id = R.id.place_jeju;
      TextView placeJeju = ViewBindings.findChildViewById(rootView, id);
      if (placeJeju == null) {
        break missingId;
      }

      id = R.id.place_jeonbuk;
      TextView placeJeonbuk = ViewBindings.findChildViewById(rootView, id);
      if (placeJeonbuk == null) {
        break missingId;
      }

      id = R.id.place_jeonnam;
      TextView placeJeonnam = ViewBindings.findChildViewById(rootView, id);
      if (placeJeonnam == null) {
        break missingId;
      }

      id = R.id.place_sejong;
      TextView placeSejong = ViewBindings.findChildViewById(rootView, id);
      if (placeSejong == null) {
        break missingId;
      }

      id = R.id.place_seoul;
      TextView placeSeoul = ViewBindings.findChildViewById(rootView, id);
      if (placeSeoul == null) {
        break missingId;
      }

      id = R.id.place_ulsan;
      TextView placeUlsan = ViewBindings.findChildViewById(rootView, id);
      if (placeUlsan == null) {
        break missingId;
      }

      id = R.id.tagsEditText;
      EditText tagsEditText = ViewBindings.findChildViewById(rootView, id);
      if (tagsEditText == null) {
        break missingId;
      }

      id = R.id.titleTextView;
      TextView titleTextView = ViewBindings.findChildViewById(rootView, id);
      if (titleTextView == null) {
        break missingId;
      }

      id = R.id.updateButton;
      Button updateButton = ViewBindings.findChildViewById(rootView, id);
      if (updateButton == null) {
        break missingId;
      }

      return new ActivityCreateBinding((ConstraintLayout) rootView, bookAuthorTextView,
          bookAuthorTextView2, bookClubNameEditText, bookImageView, bookTitleTextView,
          descriptionEditText, gridLayout, meetWhere, participantsEditText, placeBusan,
          placeChungbuk, placeChungnam, placeDaegu, placeDaejeon, placeGangwon, placeGwangju,
          placeGyeongbuk, placeGyeonggi, placeGyeongnam, placeIncheon, placeJeju, placeJeonbuk,
          placeJeonnam, placeSejong, placeSeoul, placeUlsan, tagsEditText, titleTextView,
          updateButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
