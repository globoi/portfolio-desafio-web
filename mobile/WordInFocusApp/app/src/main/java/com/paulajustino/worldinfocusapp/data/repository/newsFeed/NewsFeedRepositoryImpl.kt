package com.paulajustino.worldinfocusapp.data.repository.newsFeed

import com.paulajustino.worldinfocusapp.data.remote.newsFeed.NewsRemoteDataSource
import com.paulajustino.worldinfocusapp.domain.model.newsFeed.FeedModel
import com.paulajustino.worldinfocusapp.utils.NetworkError
import com.paulajustino.worldinfocusapp.utils.Result
import javax.inject.Inject

class NewsFeedRepositoryImpl @Inject constructor(
    private val remoteDataSource: NewsRemoteDataSource
) : NewsFeedRepository {
    override suspend fun getInitialNewsFeed(newsType: String): Result<FeedModel, NetworkError> {
        return remoteDataSource.fetchInitialNewsFeed(newsType)
    }

    /*    override suspend fun getPagedNewsFeed(
            newsType: String,
            page: Int,
            offerId: String?
        ): Flow<PagingData<NewsItemModel>> {
            return Pager(
                config = PagingConfig(
                    prefetchDistance = 5
                ),
                pagingSourceFactory = {
                    NewsFeedPagingSource(remoteDataSource, newsType, page, offerId)
                }
            ).flow
        }*/
}