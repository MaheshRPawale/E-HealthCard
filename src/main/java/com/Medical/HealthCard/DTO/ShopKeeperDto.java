package com.Medical.HealthCard.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public  class ShopKeeperDto {

    @NotNull(message = "Shopkeeper Name is Null")
    @NotEmpty(message = "Shopkeeper Name is Empty")
    private String shopkeeperName;

    @NotEmpty(message = "SHop Name is empty ")
    @NotBlank(message = "Shop Name is blank")
    private String shopName;


}
