# PVL [![Build Status](https://travis-ci.org/jrry/pvl.svg?branch=master)](https://travis-ci.org/jrry/pvl)
Polish Validation Library - Extension package for Bean Validation Framework

## Example usage

```java
@PVL_Email(message = "Incorrect or fake email address")
private String email; // with custom message

@PVL_NIP
private String nip; // default message

@PVL_IdentityCard
private String nr_i_seria_dowodu_osobistego;

@PVL_Password(min = 6, max = 25, characters = "!@#$%^&*()_-+=?.,")
private String password;

@PVL_Pesel
private String pesel;

@PVL_REGON
private String regon;

@PVL_IBAN
private String numer_konta_bankowego
```
