package cashewnut.economy.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WrapperDto<T>  {
        private T data;
}
