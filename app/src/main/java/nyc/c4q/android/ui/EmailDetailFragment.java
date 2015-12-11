package nyc.c4q.android.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import nyc.c4q.android.R;
import nyc.c4q.android.model.Email;

public class EmailDetailFragment extends Fragment {
  private Email email;
  private static final DateFormat formatter = SimpleDateFormat.getDateInstance(DateFormat.SHORT);

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    email = (Email) getArguments().getSerializable("email");
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_email_detail, container, false);

    // TODO - get references to views
    ImageView emailImage = (ImageView) view.findViewById(R.id.email_from_img);
    TextView bodyText = (TextView) view.findViewById(R.id.email_body);
    TextView subjectText = (TextView) view.findViewById(R.id.email_subject);


    // TODO - replace nulls
    Picasso.with(getActivity()).load((email.getFromUrl()) ).into(emailImage);

    // TODO - bind email data to views
      bodyText.setText(email.getBody());
      subjectText.setText(formatter + "\n" + email.getSubject());

    return view;
  }

  public static EmailDetailFragment newInstance(Email email) {
    // TODO - implement this factory method
    EmailDetailFragment fragment = new EmailDetailFragment();
    Bundle args = new Bundle();
    args.putSerializable("email", email);
    fragment.setArguments(args);


    // create fragment, set up its only argument (the email) and return it

    // hint
    //args.putSerializable("email", email);

    return fragment;
  }
}
