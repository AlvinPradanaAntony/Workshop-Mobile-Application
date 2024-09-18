package com.example.jsonmoviedb;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class FragmentMovie extends Fragment implements MovieAdapter.onSelectData {

    private RecyclerView rvFilmRecommend;
    private MovieAdapter movieAdapter;
    private ProgressDialog progressDialog;
    private List<ModelMovie> moviePopular = new ArrayList<>();

    public FragmentMovie() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_film, container, false);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Mohon Tunggu");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Sedang menampilkan data");

        rvFilmRecommend = rootView.findViewById(R.id.rvFilmRecommend);
        rvFilmRecommend.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvFilmRecommend.setHasFixedSize(true);

        getMovieHorizontal();
        getMovie();

        return rootView;
    }

    private void setSearchMovie(String query) {
        progressDialog.show();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get((ApiEndpoint.BASEURL + ApiEndpoint.SEARCH_MOVIE + ApiEndpoint.APIKEY + ApiEndpoint.LANGUAGE + ApiEndpoint.QUERY + query), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    progressDialog.dismiss();
                    moviePopular = new ArrayList<>();
                    JSONObject response = new JSONObject(new String(responseBody));
                    JSONArray jsonArray = response.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        ModelMovie dataApi = new ModelMovie();
                        SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMMM yyyy");
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                        String datePost = jsonObject.getString("release_date");

                        dataApi.setId(jsonObject.getInt("id"));
                        dataApi.setTitle(jsonObject.getString("title"));
                        dataApi.setVoteAverage(jsonObject.getDouble("vote_average"));
                        dataApi.setOverview(jsonObject.getString("overview"));
                        dataApi.setReleaseDate(formatter.format(dateFormat.parse(datePost)));
                        dataApi.setPosterPath(jsonObject.getString("poster_path"));
                        dataApi.setBackdropPath(jsonObject.getString("backdrop_path"));
                        dataApi.setPopularity(jsonObject.getString("popularity"));
                        moviePopular.add(dataApi);
                        showMovie();
                    }
                } catch (JSONException | ParseException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Gagal menampilkan data!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Tidak ada jaringan internet!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getMovieHorizontal() {
        progressDialog.show();
        AsyncHttpClient client = new AsyncHttpClient();
        client.get((ApiEndpoint.BASEURL + ApiEndpoint.MOVIE_PLAYNOW + ApiEndpoint.APIKEY + ApiEndpoint.LANGUAGE), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    progressDialog.dismiss();
                    JSONObject response = new JSONObject(new String(responseBody));
                    JSONArray jsonArray = response.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        ModelMovie dataApi = new ModelMovie();
                        SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMMM yyyy");
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                        String datePost = jsonObject.getString("release_date");

                        dataApi.setId(jsonObject.getInt("id"));
                        dataApi.setTitle(jsonObject.getString("title"));
                        dataApi.setVoteAverage(jsonObject.getDouble("vote_average"));
                        dataApi.setOverview(jsonObject.getString("overview"));
                        dataApi.setReleaseDate(formatter.format(dateFormat.parse(datePost)));
                        dataApi.setPosterPath(jsonObject.getString("poster_path"));
                        dataApi.setBackdropPath(jsonObject.getString("backdrop_path"));
                        dataApi.setPopularity(jsonObject.getString("popularity"));
                    }
                } catch (JSONException | ParseException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Gagal menampilkan data!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Tidak ada jaringan internet!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getMovie() {
        progressDialog.show();
        AsyncHttpClient client = new AsyncHttpClient();
        client.get((ApiEndpoint.BASEURL + ApiEndpoint.MOVIE_POPULAR + ApiEndpoint.APIKEY + ApiEndpoint.LANGUAGE), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    progressDialog.dismiss();
                    moviePopular = new ArrayList<>();
                    JSONObject response = new JSONObject(new String(responseBody));
                    JSONArray jsonArray = response.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        ModelMovie dataApi = new ModelMovie();
                        SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMMM yyyy");
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                        String datePost = jsonObject.getString("release_date");
                        dataApi.setId(jsonObject.getInt("id"));
                        dataApi.setTitle(jsonObject.getString("title"));
                        dataApi.setVoteAverage(jsonObject.getDouble("vote_average"));
                        dataApi.setOverview(jsonObject.getString("overview"));
                        dataApi.setReleaseDate(formatter.format(dateFormat.parse(datePost)));
                        dataApi.setPosterPath(jsonObject.getString("poster_path"));
                        dataApi.setBackdropPath(jsonObject.getString("backdrop_path"));
                        dataApi.setPopularity(jsonObject.getString("popularity"));
                        moviePopular.add(dataApi);
                        showMovie();
                    }
                } catch (JSONException | ParseException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Gagal menampilkan data!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Tidak ada jaringan internet!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showMovie() {
        movieAdapter = new MovieAdapter(getActivity(), moviePopular, this);
        rvFilmRecommend.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSelected(ModelMovie modelMovie) {
    }
}