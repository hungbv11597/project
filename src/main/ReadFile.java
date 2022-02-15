package main;
import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;


public class ReadFile {
	
	static String NhaCungCap_TieuChi_Matrix[][] ;
	static String TieuChi_DanhGia_Matrix[][]  ;
	static String Chuyenvi_Tieuchi_DanhGia[][];
	static int rows, cols;
	static min_maxFuzzy[] _min_maxFuzzy = new min_maxFuzzy[5];	
	static String NhaCungCap_DanhGia_Matrix[][] = new String[5][5];


	
	public boolean loadData(String filepath,String filepath2) throws Exception{
        // create a String array from the input file: input.txt
        String[] lines = (new String(Files.readAllBytes((new File(filepath)).toPath()))).replace("\r", "").split("\n");
       System.out.println("Gia tri do dai: " + lines[2]);
        // declare a 2-dimensional int array with the 1st dimension of lines.length
        String a[][] = new String[lines.length][]; // create a 2 dimentinal array
        rows = lines.length;
        // fill the 2nd. dimensional elements
        for (int i = 0; i < lines.length; ++i) {
          String[] x = lines[i].split(" "); // string array of each line
          a[i] = new String[x.length];  // create the 2nd dimension with the length of each line
          cols = x.length;
          for (int j = 0; j < x.length; ++j) // convert to int
            a[i][j] = x[j];
        }
        
        // create a String array from the input file: input.txt
        String[] _lines = (new String(Files.readAllBytes((new File(filepath2)).toPath()))).replace("\r", "").split("\n");
       //System.out.println("Gia tri do dai: " + _lines[2]);
        // declare a 2-dimensional int array with the 1st dimension of lines.length
        String _a[][] = new String[_lines.length][]; // create a 2 dimentinal array
        rows = lines.length;
        // fill the 2nd. dimensional elements
        for (int i = 0; i < _lines.length; ++i) {
          String[] x = _lines[i].split(" "); // string array of each line
          _a[i] = new String[x.length];  // create the 2nd dimension with the length of each line
          cols = x.length;
          for (int j = 0; j < x.length; ++j) // convert to int
            _a[i][j] = x[j];
        }
        //Khoi tao chieu cho ma tran
        
        NhaCungCap_TieuChi_Matrix= new String[40][40]; 
        TieuChi_DanhGia_Matrix = new String[100][100];
        Chuyenvi_Tieuchi_DanhGia = new String[5][5];
       for (int i=0; i<a.length;i++){
		    for(int j=0; j<a[i].length;j++){
		        //if (a[i][j].length() >= 0) bwr.write(a[i][j]+" "); 

		    	if(a[i][j].length() >= 0) {
		    		NhaCungCap_TieuChi_Matrix[i][j] = a[i][j];	   
		    		//System.out.print(i +" "+ j + NhaCungCap_TieuChi_Matrix[i][j]);
		    	}
		        //else bwr.write(" "); 
		    	else {
		    		NhaCungCap_TieuChi_Matrix[i][j] = " ";                		
		    	}
		    }     
    		//System.out.println();
		    //bwr.write("\n");
		}
       
       for (int i=0; i<_a.length;i++){
		    for(int j=0; j< _a[i].length;j++){
		        //if (a[i][j].length() >= 0) bwr.write(a[i][j]+" "); 

		    	if(_a[i][j].length() >= 0) {
		    		TieuChi_DanhGia_Matrix[i][j] = _a[i][j];	   
		    		//System.out.print(i +" "+ j + TieuChi_DanhGia_Matrix[i][j]);
		    	}
		        //else bwr.write(" "); 
		    	else {
		    		TieuChi_DanhGia_Matrix[i][j] = " ";                		
		    	}
		    }     
    		//System.out.println();
		    //bwr.write("\n");
		}

		//bwr.close();
		System.out.println("Succesfully written to a file output.txt");       
        return true;
    }
	
	public static void inThongTin() {
		System.out.println();
		System.out.println("====== Bảng mối quan hệ mờ hình ảnh giữa tập hợp nha cung cap P và tập hợp chẩn đoán D======= ");
		for(int i =0; i< 4; i++) {
			for(int j= 0; j<5; j++) {
				System.out.print(NhaCungCap_DanhGia_Matrix[i][j] + "   ");
			}
			System.out.println();			
		}							
	}
	
	public static String chuanHoaXau(String inputString) {
		inputString = inputString.replace("(", "");
		inputString = inputString.replace(")", "");
		return inputString;
		
	}
	
	
	public static String[] _repalceString(String inputString) {
		String[] words = inputString.split(",");
		for(int i =0; i< words.length; i++) {
			//System.out.println(words[i]);
		}
		
		return words;		
	}
	
	public static String chuanHoaXau2(String inputString) {
		inputString = inputString.replace("[", "");
		inputString = inputString.replace("]","");
		return inputString;
	}
	
	public static float[] _convertStringArrayToFloatArray(String [] inputString) {
		int size = inputString.length;
		float [] arr = new float [size];
		 for(int i=0; i<size; i++) {
	         arr[i] = Float.parseFloat(inputString[i]);
	      }
		 //System.out.println("_convertStringArrayToIntArray"
		 //		+ "" + Arrays.toString(arr));
		return arr;
		
	}
	//Tim ma tran chuyen vi cua ma tran tieuchi_danhgia
	public static void Matranchuyenvi() {		
		for(int i =0; i<=4; i++) {
			for(int j =0; j<=4; j++) {				
			Chuyenvi_Tieuchi_DanhGia[i][j] = TieuChi_DanhGia_Matrix[j][i];
			System.out.print(Chuyenvi_Tieuchi_DanhGia[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	public static float[] _findMax(float[] array1, float[] array2) {
		float[] _tempArray = new float[3];
		for(int i =0; i< array1.length; i++) {
			if( i <= 1) {
				if(array1[i] > array2[i]) {
					_tempArray[i] = array2[i];
				}else if(array1[i] < array2[i])
				{
					_tempArray[i] = array1[i];
				}else _tempArray[i] = array1[i];				
			}else {
				if(array1[i] > array2[i]) {
					_tempArray[i] = array1[i];
				}else if(array1[i] < array2[i]) {
					_tempArray[i] =array2[i];
				}
				else _tempArray[i] = array2[i];
			}
		}
		for(int i =0; i<=2; i++) {
			System.out.println("_findMax" + _tempArray[i]);
		}		
		return _tempArray;			
	}

	public static float[] _findMixMaxObject(min_maxFuzzy[] input) {
		float[] _output = new float[3];
		float max_mu = input[0].mu;
		float min_eta = input[0].eta;
		float min_gamma = input[0].gamma;
		
		for(int i =0; i<=4; i++) {
			//Tim max cua mu
			if(input[i].mu > max_mu) {
				max_mu = input[i].mu;
			}
			//Tim min cua eat
			if(input[i].eta < min_eta) {
				min_eta = input[i].eta;
			}
			//Tim min cua gamma
			if(input[i].gamma < min_gamma) {
				min_gamma = input[i].gamma;
			}
		}
		//gan vao mang
		_output[0] = max_mu;
		_output[1] = min_eta;
		_output[2] = min_gamma;	
		
		return _output;		
	}
	
	public static float[][] DeFuzzification(String[][] input){
		
		String[] _tempValue = new String[4] ;
		float[][] _output = new float[5][5];
		float[] output = new float[3];
		System.out.println();
		System.out.println("======= Gia tri dau ra của bảng S(T)======= ");
		for(int i =0; i<4;i++) {
			for(int j =0; j<=4; j++) {
				//_tempValue = _convertStringArrayToFloatArray(_repalceString(input[i][j]));
				
				_tempValue = _repalceString(chuanHoaXau2(input[i][j]));
				//System.out.println("Test in: " + _tempValue[2]);
				output = _convertStringArrayToFloatArray(_tempValue);
				//Tinh toan theo cong thuc: S_T (p,d)=μ_T (p,d)-γ_T (p,d)* π_T (p,d)
				_output[i][j] = output[0] - output[2]*(1 - (output[0] + output[1] + output[2]));
				System.out.print(_output[i][j] + "  ");

			}
			System.out.println();
		}
		return _output;
	}
	
	public static void Tinhtoan() {
		//loop tung hang trong ma tran NhaCungCap_TieuChi_Matrix
		String[] _tempNCC = new String[5];
		String[] _tempTieuchiDanhGia = new String[5];
		float[] _tempFindMax = new float[4];
		float[] _resultMinMaxFuzzy = new float[3];
		for(int h = 0; h<=4; h++) {
			_min_maxFuzzy[h] = new min_maxFuzzy();		
		}
		
		for( int i = 0; i < 4; i++) {
			for(int _i=0; _i<=4; _i++) {				
				for(int k =0; k<=4 ; k++) {
					_tempNCC[i] = NhaCungCap_TieuChi_Matrix[i][k];
					_tempTieuchiDanhGia[_i] = Chuyenvi_Tieuchi_DanhGia[_i][k];
					_tempFindMax = _findMax(_convertStringArrayToFloatArray(_repalceString(chuanHoaXau(_tempNCC[i]))), 
							_convertStringArrayToFloatArray(_repalceString(chuanHoaXau(_tempTieuchiDanhGia[_i]))));		
					//luu cac phan tu vao trong mang

					_min_maxFuzzy[k].setMu(_tempFindMax[0]);
					_min_maxFuzzy[k].setEta(_tempFindMax[1]);
					_min_maxFuzzy[k].setGamma(_tempFindMax[2]);
					_resultMinMaxFuzzy= _findMixMaxObject(_min_maxFuzzy);

					_min_maxFuzzy[0].inthongtin();
					//System.out.println("P" + i+": "+ Arrays.toString(_convertStringArrayToIntArray(_repalceString(chuanHoaXau(_tempNCC[i]))))+ "__" + Arrays.toString( _convertStringArrayToIntArray(_repalceString(chuanHoaXau(_tempTieuchiDanhGia[_i])))));
					System.out.println("----------------------");
					
				}
				System.out.println("Gia tri _resultMinMaxFuzzy-1: " + _resultMinMaxFuzzy[0]);
				System.out.println("Gia tri _resultMinMaxFuzzy-1: " + _resultMinMaxFuzzy[1]);
				System.out.println("Gia tri _resultMinMaxFuzzy-1: " + _resultMinMaxFuzzy[2]);
				NhaCungCap_DanhGia_Matrix[i][_i] = Arrays.toString(_resultMinMaxFuzzy);
			}
		}
	}
	
	public static void _resultDeFuzzification(float[][] inputMatrix) {
		int rows = inputMatrix.length;
		int cols = inputMatrix[0].length;
		System.out.println("=========================================");
		System.out.println("Bước giải mờ, tìm các giá trị điều khiển rõ");

		for(int i = 0; i<rows; i++) {
			if(i == 0) {
				System.out.print("P1 duoc xep hang:");
			}else  if(i==1) {
				System.out.print("P2 duoc xep hang:");
			}else if(i==2) {
				System.out.print("P3 duoc xep hang:");
			}else if(i==3) {
				System.out.print("P4 duoc xep hang:");
			}
			for(int j =0; j< cols; j++) {
				if (inputMatrix[i][j] >= 0.5) {
					if(j==0) {
						System.out.print("Trung bình,");
					}else if(j ==1) {
						System.out.print("Trung bình khá,");
					}else if(j==2) {
						System.out.print("Khá,");
					}else if(j==3) {
						System.out.print("Khá tốt,");
					}else if(j==4) {
						System.out.print("Tốt,");
					}
				}
			}
			System.out.println();
		}
		
		return;
	}
	
    public static void main(String[] args) throws Exception {
    	float [][] _outputDeFuzzificationMatrix = new float[5][5];
        new ReadFile().loadData("input1.txt","input2.txt");
        Matranchuyenvi();
        Tinhtoan();
        inThongTin();
        _outputDeFuzzificationMatrix = DeFuzzification(NhaCungCap_DanhGia_Matrix);
        _resultDeFuzzification(_outputDeFuzzificationMatrix);
      // _convertStringArrayToIntArray(_repalceString("0.1,0.2,0.6"));
 
    }
}
