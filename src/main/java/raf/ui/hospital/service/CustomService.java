package raf.ui.hospital.service;

import java.util.List;

public interface CustomService {

    List<String[]> query1(String param);
    String query2(String param);
    Long query3();
    List<String[]> query4();
    String query5();
    List<String> query6();
    Double query7(String firstName, String lastName);
}
