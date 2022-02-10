package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * I'd say that on card click, we can probably do a thing very similar to the ICA, right?
         * Preferably we also make a "return to previous screen button" right there as well, without needing to click at the top left corner? For convenience, that is.
         * To be honest I think that it's better for us not to cram the initial card with details.
         * Instead, we can just put all the necessary information in the after screen. (Maybe we can keep the image, name, and price, and leave the rest to the next screen.)
         *
         * For customer reviews, do you also want to do a similar card thing?
         * It feels like the organisation can work in a very similar way ~~so we can just copy the code over~~
         * And yes, the new user sign-up part isn't hard, I guess? It's just Y3 CS stuff I assume.
         */

    }
}
