package ch.yvesbeutler.xml.example.numbers.integers;

import javax.xml.bind.annotation.XmlEnum;


@XmlEnum(String.class)
public enum Sign { plus, minus; }