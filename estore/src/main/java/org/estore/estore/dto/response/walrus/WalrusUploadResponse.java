package org.estore.estore.dto.response.walrus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WalrusUploadResponse {
    private NewlyCreated newlyCreated;
    private AlreadySatisfied alreadySatisfied;
}
