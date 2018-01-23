package com.privalia.albert.challange.presentation.ui.viewModel;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.privalia.albert.challange.presentation.R;
import com.privalia.albert.challange.presentation.model.MovieModel;
import com.squareup.picasso.Picasso;

import java.util.Date;

/**
 * Created by albert on 23/1/18.
 */

public class MovieItemViewModel {

    public ObservableField<String> imageUrl;
    public ObservableField<String> title;
    public ObservableField<String> year;
    public ObservableField<String> overview;

    public MovieItemViewModel(MovieModel movie) {
        this.imageUrl = new ObservableField<String>(movie.getPosterPath());
        this.title = new ObservableField<String>(movie.getOriginalTitle());
        Date releaseDate = movie.getReleaseDate();
        this.year = new ObservableField<String>(releaseDate == null ? "" : releaseDate.toString());
        this.overview = new ObservableField<String>(movie.getOverview());
    }


    public ObservableField<String> getImageUrl() {
        // The URL will usually come from a model (i.e Profile)
        return this.imageUrl;
    }

    @BindingAdapter({"bind:image_poster"})
    public static void loadImage(ImageView view, String imageUrl) {
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Picasso.with(view.getContext())
                    .load(imageUrl)
                    .error(R.drawable.error_image)
                    .placeholder(R.drawable.progress_animation)
                    .into(view);
        } else {
            view.setImageDrawable(
                    view.getContext().getResources().getDrawable(R.drawable.no_image_available));
        }
    }
}
