package com.thesis.webspajz.model.jsonRepresent.details;

import lombok.Getter;

@Getter
public class Images {

    private String hostedLargeUrl = null;
    private String resizableImageUrl = null;

    public void setHostedLargeUrl(String hostedLargeUrl) {
        if (hostedLargeUrl != null && !hostedLargeUrl.equals("")) {
            this.hostedLargeUrl = hostedLargeUrl;
        }
    }

    public void setResizableImageUrl(String resizableImageUrl) {
        if (resizableImageUrl != null && !resizableImageUrl.equals("")) {
            this.resizableImageUrl = resizableImageUrl;
        }
    }
}
