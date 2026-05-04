package com.turkcell.libraryapp.dto.yayinevi.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record YayineviCreateRequest(

        @NotBlank(message = "Yayınevi adı boş bırakılamaz.")
        String yayineviAd,

        @NotBlank(message = "Telefon numarası boş bırakılamaz.")
        @Pattern(regexp = "^[0-9]{11}$", message = "Telefon numarası 11 haneli olmalıdır.")
        String telefonNo,

        @Min(value = 1, message = "Türkiye için geçerli bir il numarası giriniz")
        @Max(value = 81, message = "Türkiye için geçerli bir il numarası giriniz")
        int ilKodu
) {
}