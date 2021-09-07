package hackerrank.Java;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

public class ComparatorHR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while ( testCases > 0 ) {
            int id = in.nextInt();
            String fname = in.next();
            double CGPA = in.nextDouble();

            Student st = new Student(id, fname, CGPA);
            studentList.add(st);

            testCases--;
        }

        final Comparator<Student> CGPAORDER = new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return Double.compare(o2.getCgpa(), o1.getCgpa());
            }
        };

        final Comparator<Student> FNAMEORDER = new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return (o1.getFname()).compareTo(o2.getFname());
            }
        };

        final Comparator<Student> IDORDER = new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        };

        Collections.sort(studentList, CGPAORDER.thenComparing(FNAMEORDER).thenComparing(IDORDER));;
        
        for(Student st: studentList){
			System.out.println(st.getFname());
		}

        in.close();
    }

}


/**
 * *********************************************************************
Input #1
5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76

Expected Output
Ashis
Fahim
Samara
Samiha
Rumpa

Input #2
 100
1 PdeLwCYcXHBUyDovShzHKI 1.85
2 XHjqMumVZfSW 0.18
3 zXiGscYethmwLgalEVwuSGdzxI 0.17
4 ggjwTvvaAraioUNmKKfKWwA 1.13
5 PrvDm 1.38
6 NnDGDcEQ 1.59
7 hyDbVOGaobNkXZR 2.39
8 HYasEeNIkTsDSnuMXQGDuFIZuGen 2.01
9 AVSHnKvDZorlL 3.46
10 aOdxZenFiSfZzoO 3.32
11 PnfTXKEvdJeLaciXAIooDmqlTuBxJL 1.30
12 FSXEeOwelNxMVutJDFjEzLm 0.81
13 QryjiTfrkcUGnJBnkzAWwdiqJhZqh 1.87
14 YVTVYxRUiAoFNNgHJGyF 0.70
15 dofSxfFEwPPnKwFfVsynJkBDhumIA 1.52
16 JXneisxgkeLkak 2.98
17 hjBCAXDgihUqPExDuRrJcz 1.15
18 fwXRzErDWcyKjPxbOfApVJx 1.81
19 YAmyNFyT 0.12
20 VSgQTgiqNyQMRerhQdLRUemcEQX 3.75
21 tMloJlO 1.18
22 yvOgyJLb 3.21
23 VDhZY 3.14
24 XvxXsDKIjkFJHiWTOkd 3.37
25 mcNnINTMSdpMxwTApWSJ 2.72
26 vosdf 2.00
27 DHRSaJQJdJiJBmxjmLouQ 2.80
28 KvzKzel 0.10
29 xcRgist 0.23
30 QWPwPuN 1.58
31 sydIngROEZHupsHzPFFpXhZh 3.02
32 yNXtoxp 0.78
33 bGVtEfpjOniybCxKYVrPMkqbhVYsG 3.19
34 bsbxNbUVvECrfSV 3.51
35 fRHKrHh 0.16
36 XgBjLqwusge 1.57
37 jTkQkHxwAKfyykjWiyJKTqcCUZ 2.26
38 ZZDGEToBqnxnPK 2.13
39 pVGMylZEC 2.64
40 UhhdgCqcOuWAJOFWKqsGUGw 3.62
41 keyYAGA 0.03
42 MkVKGyExPayZExpJEl 0.42
43 uMwoJFugvXGnSgaApSIzNN 3.79
44 BmnINxoKI 0.91
45 toTIoHWsZB 0.36
46 xvIUeYZMlBrRbAUxcLtzLPdjORQIYZ 0.81
47 LIaCQ 1.28
48 jadiayxBP 1.18
49 NQfoFodr 0.48
50 QumKkEcRFIdHaTHudcvHjEAYlAnkn 1.99
51 hlTgCgoFvpFUSXTssbQ 3.55
52 mzEhSqlRtxslyNZZnmCGGdvJbujoIe 0.97
53 ABAJwYeibIJQ 3.58
54 KUlxpQpgbCPp 2.61
55 XhhoNTJ 2.06
56 nTBfkiqGrAem 1.78
57 ArFnJ 1.33
58 tzqGKOBIHnl 0.86
59 gmWXph 3.85
60 KkKNPuDXiddAsnCQZgnMQyhJqB 2.47
61 PDpUZLlXiihnpYCmDCor 2.62
62 WneXKKERUBQ 1.57
63 NElkBCFZUUJBLLcVjQn 1.48
64 mdOtOeFpyLW 2.73
65 FOIzcUHOGYTBnGLn 0.02
66 ibyUYmXdfoAW 3.75
67 wCZQpyjUBfEmZpApljyxKbPv 2.04
68 fmbSzWBAFYvgvYoAfNgh 0.56
69 rAFMZelAhtAYs 0.12
70 IwQmGhDJAiExVBjUmHXAfvUDqUyksh 3.38
71 CEoQmJhGNuufStMmSAHCj 0.95
72 LtbWRlEpzNbawIIo 3.94
73 FxwndjRHEXgXaXYw 1.55
74 euKDKBZrwqODRtIyWji 2.01
75 ssLafrVwU 3.93
76 ZlusqchpsvpSimDBnocPXdgCW 1.52
77 FfMtpOUNvGKBETc 2.39
78 WJTKFI 0.36
79 bHfivIcusSyRnaovkBZazI 1.87
80 RzXoSUoHEcIH 1.73
81 dkrlgltSHdWFTvldivCmKGIRdp 0.60
82 NDnPzRMahqJNvqArVFrqrZOphOAHO 0.19
83 tVsahPGsuJFIQ 1.37
84 EcKbvrkcWEkqZZMHXnqzjTSG 2.68
85 EnSVRSXzsyWuCMVVe 2.15
86 qJOdMwks 2.09
87 tNDpFOSdpdUfUbzkcINKdHIaZxV 0.28
88 VkNpJJXfFnzBclOPwIvdabTxqSzFJ 2.97
89 SjqGgkIlXdWxmVgZkrqgaBX 1.28
90 agPfUmvm 1.79
91 oWgzOedgOdRozRaEymNOLPRCqvl 0.60
92 LdHAmtvQLIEpXoWwmhfEDmguyJ 1.61
93 hYGUutHgTzGQhWM 1.89
94 FEXmMZqytnoWRMACuad 1.15
95 wAEauaPeHuTdnyQY 0.75
96 vcGdlaKlNsEp 0.90
97 OllfZlACfxPdXgsM 1.56
98 FlbyiCXNChMaokOglrGd 0.25
99 dwBNMwtQwYeZprqQpXK 1.70
100 vZuGpylfeQrliAXfJT 2.45

Expected Output
LtbWRlEpzNbawIIo
ssLafrVwU
gmWXph
uMwoJFugvXGnSgaApSIzNN
VSgQTgiqNyQMRerhQdLRUemcEQX
ibyUYmXdfoAW
UhhdgCqcOuWAJOFWKqsGUGw
ABAJwYeibIJQ
hlTgCgoFvpFUSXTssbQ
bsbxNbUVvECrfSV
AVSHnKvDZorlL
IwQmGhDJAiExVBjUmHXAfvUDqUyksh
XvxXsDKIjkFJHiWTOkd
aOdxZenFiSfZzoO
yvOgyJLb
bGVtEfpjOniybCxKYVrPMkqbhVYsG
VDhZY
sydIngROEZHupsHzPFFpXhZh
JXneisxgkeLkak
VkNpJJXfFnzBclOPwIvdabTxqSzFJ
DHRSaJQJdJiJBmxjmLouQ
mdOtOeFpyLW
mcNnINTMSdpMxwTApWSJ
EcKbvrkcWEkqZZMHXnqzjTSG
pVGMylZEC
PDpUZLlXiihnpYCmDCor
KUlxpQpgbCPp
KkKNPuDXiddAsnCQZgnMQyhJqB
vZuGpylfeQrliAXfJT
FfMtpOUNvGKBETc
hyDbVOGaobNkXZR
jTkQkHxwAKfyykjWiyJKTqcCUZ
EnSVRSXzsyWuCMVVe
ZZDGEToBqnxnPK
qJOdMwks
XhhoNTJ
wCZQpyjUBfEmZpApljyxKbPv
HYasEeNIkTsDSnuMXQGDuFIZuGen
euKDKBZrwqODRtIyWji
vosdf
QumKkEcRFIdHaTHudcvHjEAYlAnkn
hYGUutHgTzGQhWM
QryjiTfrkcUGnJBnkzAWwdiqJhZqh
bHfivIcusSyRnaovkBZazI
PdeLwCYcXHBUyDovShzHKI
fwXRzErDWcyKjPxbOfApVJx
agPfUmvm
nTBfkiqGrAem
RzXoSUoHEcIH
dwBNMwtQwYeZprqQpXK
LdHAmtvQLIEpXoWwmhfEDmguyJ
NnDGDcEQ
QWPwPuN
WneXKKERUBQ
XgBjLqwusge
OllfZlACfxPdXgsM
FxwndjRHEXgXaXYw
ZlusqchpsvpSimDBnocPXdgCW
dofSxfFEwPPnKwFfVsynJkBDhumIA
NElkBCFZUUJBLLcVjQn
PrvDm
tVsahPGsuJFIQ
ArFnJ
PnfTXKEvdJeLaciXAIooDmqlTuBxJL
LIaCQ
SjqGgkIlXdWxmVgZkrqgaBX
jadiayxBP
tMloJlO
FEXmMZqytnoWRMACuad
hjBCAXDgihUqPExDuRrJcz
ggjwTvvaAraioUNmKKfKWwA
mzEhSqlRtxslyNZZnmCGGdvJbujoIe
CEoQmJhGNuufStMmSAHCj
BmnINxoKI
vcGdlaKlNsEp
tzqGKOBIHnl
FSXEeOwelNxMVutJDFjEzLm
xvIUeYZMlBrRbAUxcLtzLPdjORQIYZ
yNXtoxp
wAEauaPeHuTdnyQY
YVTVYxRUiAoFNNgHJGyF
dkrlgltSHdWFTvldivCmKGIRdp
oWgzOedgOdRozRaEymNOLPRCqvl
fmbSzWBAFYvgvYoAfNgh
NQfoFodr
MkVKGyExPayZExpJEl
WJTKFI
toTIoHWsZB
tNDpFOSdpdUfUbzkcINKdHIaZxV
FlbyiCXNChMaokOglrGd
xcRgist
NDnPzRMahqJNvqArVFrqrZOphOAHO
XHjqMumVZfSW
zXiGscYethmwLgalEVwuSGdzxI
fRHKrHh
YAmyNFyT
rAFMZelAhtAYs
KvzKzel
keyYAGA
FOIzcUHOGYTBnGLn



 *********************************************************************/