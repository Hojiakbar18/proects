package uz.apelsin.apelsinserver.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private boolean success;
    private String message;
    private Object object;
    private long totalElements;

    public ApiResponse(String message, boolean success) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(boolean success, String message, Object object) {
        this.success = success;
        this.message = message;
        this.object = object;
    }

    public ApiResponse(String message) {
        this.message = message;
    }
}