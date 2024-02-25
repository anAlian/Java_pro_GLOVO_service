package org.mycompany.glovo.controller.responce;
import lombok.Data;
import java.util.List;
@Data
public class ApiResponse <D> {
    private boolean success;
    private D data;
    private List<String> messages;
}
