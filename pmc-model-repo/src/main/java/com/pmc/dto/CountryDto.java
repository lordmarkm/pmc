package com.pmc.dto;

/**
 * 
 * @author Mark Martinez, Nov 21, 2015
 *
 */
public class CountryDto {

    private String name;
    private String code;
    private long sequence;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public long getSequence() {
        return sequence;
    }
    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

}
