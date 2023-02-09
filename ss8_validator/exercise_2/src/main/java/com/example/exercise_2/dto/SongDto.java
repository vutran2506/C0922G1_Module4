package com.example.exercise_2.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class SongDto implements Validator {
    private int id;
    @NotEmpty(message = "Không được để trống")
    @Size(max = 800,message = "Số kí tự không quá 800 kí tự")
    @Pattern(regexp = "^[a-z A-Z]+$",message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    @NotBlank(message = "Không được chứa kí tự bắt đầu bằng dấu cách")
    private String nameSong;
    @NotEmpty(message = "Không được để trống")
    @Size(max = 300,message = "Số kí tự không quá 300 kí tự")
    @Pattern(regexp = "^[a-z A-Z]+$",message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    @NotBlank(message = "Không được chứa kí tự bắt đầu bằng dấu cách")
    private String singer;
    @Size(max = 1000,message = "Số kí tự không quá 800 kí tự")
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[a-z A-Z]+$",message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    @NotBlank(message = "Không được chứa kí tự bắt đầu bằng dấu cách")
    private String category;

    public SongDto() {
    }

    public SongDto(int id, String nameSong, String singer, String category) {
        this.id = id;
        this.nameSong = nameSong;
        this.singer = singer;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    @Override
    public void validate(Object target, Errors errors) {
//        SongDto musicDto = (SongDto) target;
//        String song = musicDto.getNameSong();
//        if (song.length()>800){
//            errors.rejectValue("nameSong","nameSongError1","Không được quá 800 ký tự");
//        } else if (song.matches("^[@|#|$|%|^|&|*(|)|+|-]+$")) {
//            errors.rejectValue("nameSong","nameSongError2","Có chứ kí tự đặc biệt");
//        }
    }
}
