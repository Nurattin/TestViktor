package com.example.testviktor.ui.base.route

const val DETAIL_BLOG_ROUTE = "detail_blog"
const val DETAIL_BLOG_ARGUMENT = "blogId"


sealed class ScreenRoute(val route: String) {

    object DetailBlog : ScreenRoute(route = "$DETAIL_BLOG_ROUTE/{$DETAIL_BLOG_ARGUMENT}") {
        fun passBlogId(blogId: Int): String {
            return this.route.replace(
                oldValue = "{$DETAIL_BLOG_ARGUMENT}",
                newValue = blogId.toString()
            )
        }
    }
}