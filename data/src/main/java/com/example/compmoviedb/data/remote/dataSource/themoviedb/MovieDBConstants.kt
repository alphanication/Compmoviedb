package com.example.compmoviedb.data.remote.dataSource.themoviedb

object MovieDBConstants {
    /* KEYS */
    const val MOVIE_DB_KEY = "e57c71791b41b1b6d48678746aa69e44"

    /* URL */
    const val MOVIES_POPULAR_URL = "3/movie/popular"
    const val MOVIES_BY_ID_URL = "3/movie/{movie_id}"
    const val LIST_VIDEO_MOVIE_BY_ID_URL = "3/movie/{movie_id}/videos"
    const val LIST_ACTORS_MOVIE_BY_ID_URL = "3/movie/{movie_id}/videos"

    /* PATH */
    const val MOVIE_ID_PATH = "movie_id"

    /* QUERY */
    const val API_KEY_QUERY = "api_key"
    const val LANGUAGE_QUERY = "language"
}

enum class LanguageCodes() {
    RU,
    EN
}