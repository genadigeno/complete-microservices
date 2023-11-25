package geno.ms.ui.controller.message;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class MessageBody {
    @NotNull
    private String message;
    @Min(2)
    private String author;
}
