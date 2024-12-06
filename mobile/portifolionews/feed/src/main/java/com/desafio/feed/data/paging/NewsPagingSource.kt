package com.desafio.feed.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.desafio.feed.data.response.NetworkResponse
import com.desafio.feed.data.response.handleApi
import com.desafio.feed.data.service.FeedService
import com.desafio.feed.domain.model.News
import javax.inject.Inject

class NewsPagingSource @Inject constructor(
    private val feedService: FeedService,
    private val product: String,
    private val id: String
) : PagingSource<Int, News>() {

    override fun getRefreshKey(state: PagingState<Int, News>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, News> {
        return try {

            val currentPage = params.key ?: 5

            val response = handleApi {
                feedService.fetchNextPageFeed(
                    product = product,
                    nextPage = currentPage,
                    id = id
                )
            }

            if (response is NetworkResponse.Success) {
                LoadResult.Page(
                    data =  response.value.feed.falkor.items,
                    prevKey =  if (currentPage == 1) null else currentPage - 1,
                    nextKey = response.value.feed.falkor.nextPage + 1
                )
            } else {
                throw IllegalStateException("Something wrong")
            }
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

}
