package java8;

import java.util.ArrayList;
import java.util.List;

import com.tuyano.springboot.dto.SelectItemDTO;

/**
 * ラムダ式
 */
public class Java01Lambda {
	public static void main(String[] args) {
		// ■ラムダ式01（引数なし）
		// ■Java7（ラムダ式の前）
		InterfaceTest it7 = new InterfaceTest() {
			public void method() {
				System.out.println("Hello World");
			}
		};
		it7.method();
		// ■Java8（ラムダ式）
		InterfaceTest it81 = () -> System.out.println("Hello World");
		it81.method();

		// ■ラムダ式02（引数あり）
        InterfaceTest2 it82 = a -> System.out.println(a.length());
        it82.method("Hello World");

        // ■ラムダ式03（戻り値あり）
        InterfaceTest3 it83 = () -> {return 1;};
        System.out.println(it83.method());


        // ストリーム
        List<SelectItemDTO> list = new ArrayList<SelectItemDTO>();
        SelectItemDTO newDTO = new SelectItemDTO();
        newDTO.setCode("aaa");
        newDTO.setLabel("aaaラベル");
        list.add(newDTO);

        newDTO = new SelectItemDTO();
        newDTO.setCode("bbb");
        newDTO.setLabel("bbbラベル");
        list.add(newDTO);

        // Java7
//        for (SelectItemDTO wk : list) {
//        	System.out.println(wk.getCode() + ":" + wk.getLabel());
//        }

        list.stream().forEach( dto -> {
        	dto.setCode(dto.getCode() + "x");
            System.out.println(dto.getCode() + ", " + dto.getLabel() );
        });


        list.stream().forEach(System.out::println);

	}

	// インターフェース
	interface InterfaceTest {
		// 抽象メソッド
		public void method();
	}
	interface InterfaceTest2{
		// 抽象メソッド
		public void method(String s);
	}
	interface InterfaceTest3{
		// 抽象メソッド
		public int method();
	}

}
