package com.cheaclo.userdatabase.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FavouriteProductRequestBody {
    @NotNull
    private Long userId;

    @NotNull
    private Long productId;
}
