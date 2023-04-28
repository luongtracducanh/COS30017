# Listeners

Event-driven programming is where the program is reacting to events. This is of importance to mobile as the app needs to be responsive to the input from the user.

The first step in looking at this is by working with buttons.

There are three different approaches in this app of reacting to button clicks.

## Use a lambda expression

The station button uses a lambda expression; note that this should start with `v ->` but as the v is not used this can be dropped.

This is probably the approach you'll see most often.

````
station.setOnClickListener {
    image.setImageDrawable(getDrawable(R.drawable.station))
}
````

## Use a function and assign in the layout

The college button uses a function, which is assigned in the onClick attribute for the button in the layout.

Note that onClick functions need to take a View as a parameter; if you can't see your function name in the dropdown list in the layout then that is the likely explanation why.

````
fun onClickCollege(v: View) {
    val image = findViewById<ImageView>(R.id.imageView)
    image.setImageDrawable(getDrawable(R.drawable.college))
}
````

This approach is good if you have a fear of lambdas.

## Create instance of anonymous class inheriting View.OnClickListener

The last approach for the theatre would be familiar to Java programmers.

The overhead here is in creating the class instance; this is probably not useful for something to be run once.

````
val onClickTheatre = View.OnClickListener {
    image.setImageDrawable(getDrawable(R.drawable.theatre))
}

theatre.setOnClickListener(onClickTheatre)
````

A more Kotlin-y approach would be that of onClickTheatre2, in which a function is declared as a property.

The handy thing about the approach is that the property can be set to null for no action or for scaffolding.

````
var onClickTheatre2: (() -> Unit)? = {
   image.setImageDrawable(getDrawable(R.drawable.theatre))
}

theatre.setOnClickListener { onClickTheatre2?.invoke() }
````
