package cashewnut.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WrapperDto<T>  {
        private T data;
}
