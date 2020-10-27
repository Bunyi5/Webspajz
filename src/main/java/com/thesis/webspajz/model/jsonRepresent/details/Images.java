package com.thesis.webspajz.model.jsonRepresent.details;

import lombok.Getter;

@Getter
public class Images {

    private String hostedLargeUrl = "";
    private String resizableImageUrl = "";

    public void setHostedLargeUrl(String hostedLargeUrl) {
        if (hostedLargeUrl != null) {
            this.hostedLargeUrl = hostedLargeUrl;
        }
    }

    public void setResizableImageUrl(String resizableImageUrl) {
        if (resizableImageUrl != null) {
            this.resizableImageUrl = resizableImageUrl;
        }
    }
}
