package com.example.myapplication.data

object Expandable_data_course {
    val data:HashMap<String, List<String>>
        get(){
            val expandabelListDetail = HashMap<String, List<String>>()
            val react: MutableList<String> = ArrayList()
            react.add("JSX")
            react.add("Components")
            react.add("Props")
            react.add("State")
            react.add("Lifecycle")
            react.add("Events")
            react.add("Hooks")
            val laravel: MutableList<String> = ArrayList()
            laravel.add("Routing")
            laravel.add("Eloquent ORM")
            laravel.add("Controllers")
            laravel.add("Blade templating")
            laravel.add("Artisan")
            val kotlin: MutableList<String> = ArrayList()
            kotlin.add("Coroutines")
            kotlin.add("Control flow")
            kotlin.add("Functional programming")
            kotlin.add("Generics")
            kotlin.add("Reflection")
            expandabelListDetail["React"] = react
            expandabelListDetail["Laravel"] = laravel
            expandabelListDetail["Kotlin"] = kotlin
            return expandabelListDetail

        }


}