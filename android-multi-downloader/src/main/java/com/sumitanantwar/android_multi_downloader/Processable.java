package com.sumitanantwar.android_multi_downloader;

import java.io.File;
import java.net.HttpURLConnection;

/**
 * Created by Sumit Anantwar on 2/8/17.
 */

public class Processable extends Downloadable {

    private String cacheFilPath;
    private long downloadedContentSize;
    private long totalContentSize;

    Processable(String cacheDir, Downloadable downloadable)
    {
        super(downloadable.getTargetUrl(), downloadable.getDestinationPath());
        setOnDownloadListener(downloadable.getOnDownloadListener());
        setTag(downloadable.getTag());
        setResponseCode(downloadable.getResponseCode());
        
        cacheFilPath = cacheDir + File.separator + downloadable.hashCode();
    }

    void setDownloadedContentSize(long downloadedContentSize) {
        this.downloadedContentSize = downloadedContentSize;
    }
    long getDownloadedContentSize() {
        return downloadedContentSize;
    }

    long getTotalContentSize() {
        return totalContentSize;
    }

    void setTotalContentSize(long totalContentSize) {
        this.totalContentSize = totalContentSize;
    }

    String getCacheFilePath() {
        return this.cacheFilPath;
    }

    long getPendingContentSize() {

        return (getResponseCode() == HttpURLConnection.HTTP_OK) ? (totalContentSize -downloadedContentSize) : 0;
    }
}
