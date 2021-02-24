package com.example.apiApp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_web_view.*

class WebViewFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //Fragmentが初めてUIを描写するときにシステムを呼び出す
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Fragemntとlayoutを紐づけ
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }

    //UIパーツの設定等を行う
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView.settings.javaScriptEnabled = true
        textView.settings.loadWithOverviewMode = true
        textView.settings.useWideViewPort = true

        val args = arguments?.getString("BUNDLE_KEY_URL")
        if (args != null) {
            textView.loadUrl(args)
        }
    }

    companion object {

        fun newInstance(url: String): WebViewFragment {
            val fragment = WebViewFragment()
            val args = Bundle()

            args.putString("BUNDLE_KEY_URL", url)
            fragment.arguments = args

            return fragment
        }
    }
}