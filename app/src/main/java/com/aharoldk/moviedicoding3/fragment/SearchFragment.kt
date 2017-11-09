package com.aharoldk.moviedicoding3.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.aharoldk.moviedicoding3.R
import com.aharoldk.moviedicoding3.adapter.MovieAdapter
import com.aharoldk.moviedicoding3.api.APIClient
import com.aharoldk.moviedicoding3.api.APIInterface
import com.aharoldk.moviedicoding3.model.Movie
import com.aharoldk.moviedicoding3.model.ResultsItem
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_search.view.*


/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {
    private val TAG = "SearchFragment"

    private var adapter: MovieAdapter? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    private var listResultItem = ArrayList<ResultsItem>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_search, container, false)

        layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        adapter = MovieAdapter(listResultItem)

        view.btnCari.setOnClickListener({
            v -> callRetrofit(view, view.etSearch.getText().toString())
        })

        return view
    }

    private fun callRetrofit(view: View, search: String) {

        view.rvSearch.layoutManager = layoutManager
        view.rvSearch.adapter = adapter

        val apiInterface = APIClient.getApiClient().create(APIInterface::class.java)

        val API_KEY = "3ee47da55c8dae070eb764306712efc3"
        val LANG = "en-US"

        val call = apiInterface.getSearchMovie(API_KEY, LANG, search)

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Movie> {
                    override fun onSubscribe(@NonNull d: Disposable) {

                    }

                    override fun onNext(@NonNull movie: Movie) {
                        Log.d(TAG, "List Movie = "+movie)

                        listResultItem = movie.results as ArrayList<ResultsItem>
                        view.rvSearch.adapter = MovieAdapter(listResultItem)

                    }

                    override fun onError(@NonNull e: Throwable) {

                    }

                    override fun onComplete() {

                    }
                })
    }

}
