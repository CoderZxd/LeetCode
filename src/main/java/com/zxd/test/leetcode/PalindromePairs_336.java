package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/palindrome-pairs/
 * @Author zouxiaodong
 * @Date 2020/08/06 8:40
 */
//336. 回文对
//        给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
//
//        示例 1:
//
//        输入: ["abcd","dcba","lls","s","sssll"]
//        输出: [[0,1],[1,0],[3,2],[2,4]]
//        解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
//        示例 2:
//
//        输入: ["bat","tab","cat"]
//        输出: [[0,1],[1,0]]
//        解释: 可拼接成的回文串为 ["battab","tabbat"]
public class PalindromePairs_336 {

    public static void main(String[] args) {
        PalindromePairs_336 pairs = new PalindromePairs_336();
//        List<List<Integer>>  result = pairs.palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"});
//        List<List<Integer>>  result = pairs.palindromePairs(new String[]{"bat","tab","cat"});
        List<List<Integer>>  result = pairs.palindromePairs(new String[]{"igddci","icifbh","fcbhgfjghbfh","fgj","hcfehdja","hgbgjefifhehebjeag","gaehbjjgjbadagfadaij","hbhiajabdcecf","jaaedafhcd","jcfafajcf","fhiadejj","aigafgjhe","c","dihbaaebgjc","ejfhibejjgjagjfg","gdifdbebaid","jbfbfi","gj","bjbhiijjejbb","aebdfjdeiaag","cagaahjebacchicj","djbbgj","cefcgebfdee","jicdgjb","ijdcdic","fcadiiejhigjhigfcd","ffejeicaacdiei","fjecgfigijididc","f","bahijii","bheiiehcg","bjhjgi","hfhiceaj","eddi","cbicae","jdecijhebh","cajcbjahehaa","cdecadifahdegecfc","cfdfaedj","gdhbcacfcadedgif","fegahcdace","cffecgaeea","hhcc","jegiiadbjdehhebehc","cebficjbeihcbdjg","hcgjc","ga","dg","hig","iadbghfgdhgc","ihhf","ahicbd","ehii","chgjb","afjcbe","ajidfebh","jjgffhijfaee","fbcjccghih","dehbjigcafhaacjigcbf","gcjggjjacjegaggjbjg","fgbjdhg","d","jifhbhcifjcbfaj","ajhecdcbbggibbj","ejdhhahecddha","dfieiddfdhhjeaca","gecdadfgebb","fdaiaaabdebgifbhge","gjhfgjahcfa","aaggiejjiefhg","fccjajh","dddedbjihf","eihh","dcgcfaeif","jfbbddbgjggfii","ggidjd","bdbafhicdhcheffdbibj","egicbbcgb","acdheiajh","g","jgiacdfeddjcjaf","daefai","edbagc","ajjbceijhfa","cigfhcjjhbdbbgdj","jcfbfccfiafjhcffghd","gbc","i","ajccgiddj","cgaggfgeg","cjibghdeddbj","fbgb","bhcaiedchgcbgbg","iaghea","fejfc","hdhejhdeaghe","eieadjhjagbhh","ibdjgc","agegbdicacebgi","hiaaicchecebccchebe","hgbaiejjgjfhjjjcagcc","ihcddfb","ebjidcefdcibh","iiibbejjedjcgcecgaaj","ffgccccghfefcjcgg","ediajdeghcfihgbefh","fcigdffbjj","hiiacidadcg","gecaebhgacjijaabff","higcdgejeagefaje","hjebe","fjafdjbdcgjf","hcgeae","gegefj","jciebca","edicggjgcjbbbef","cah","ddbafidgcbbjaj","ihddaehiecciajfj","jichab","ihff","ahejbchd","eafghcihjhajih","fagiacebedbb","ajcfe","eahafee","gjefeficgaefdedhhjd","hb","eg","bidcgbbcdeec","heigfb","fjgciafbicddf","j","ccbhhbh","adeacbddice","jhafgfh","bfghejaabffgghbhg","gdiejfchf","hddhh","hhjddigeddijebagghj","cjjfdaiegaaahde","daadciddjefgb","aiiicccbf","gbf","bgcceejjhfe","efgfhcffjbjifdbhdcie","bchgfbbgbigdbdagad","hcgefagccgebbeajbei","hdcefhbggjfdffjhc","jdheaijcf","eahbghhggad","ffejcj","cajjice","aigjfchhi","ibbefjcbhbhagfigjb","ggjidifedjae","bbcbfggia","dhgegbgecccdibfi","hedgiadi","hecbcfjd","cefghjagafaejhd","fg","gi","gadjeeicdahhahhbig","egbghf","geiieebc","cchfjegcibcf","bda","h","cj","bdhidefihj","gb","cajj","aaieecjhicajgd","jccdfjjcjjcfhfihch","gbbdabdcj","ffe","aff","ciidjgeadghhiafhjacf","jageijbhegafadi","gcfbeebjdg","ebccjecehcfi","jebggc","eibeiefdhdic","bh","jc","cacb","gabjajebeahhebc","a","gibfaagc","abfbjbajffbiaachcibg","ghebiffjjfebhdiehad","ifejbdgefjjghg","dggbfjba","jigjbifhcbdb","ieidchj","aifgigabgf","aceghbbijjhha","iag","ibfcjcahhhgeg","b","ghaffeddgg","agfjcdfgagghaeeaie","hdibfgihfdahhhdjc","cgdeafgjbhjiadabdd","hjicaehaijbadjii","jjebiddhgeficefcjb","edcjjjieegeg","aghfgibjfed","bbhcachbdacehdaaae","jbidhbgb","jah","igajbfdjicjdhidefd","ecbgcja","aifdfiifcacdafjgih","ajiba","fchbbcbdaidbfhj","bhdbjaefdd","ehefedjjdadgfbhb","effcdi","gghcgahgbbd","deii","eeegjibdjb","aebaegbbf","gffbbjac","gjbbcgfgc","fcfbgfedff","cahfafdifbjhjae","bfggjieacigdbhgbgee","jhbabhahjebe","dcefajjdgibhbedh","hejja","jggafgeaegh","iihdgaddegibbief","bcj","icbibgcedcffjcfj","eaeacdj","cghedabdcdhdjj","egihjfbajeib","dfiegchgefgjg","e","gcbeihefajhj","hcddjbdjj","jjgiiddcbijhjadhjdij","jiia","aibcggi","edgdbiegacghjde","edhji","eidfcfcgbdad","bie","dabdajcdbffhffgcgc","gdffhaafgiefd","jhjddj","gidbdhjj","jeediaaecjfgaaiff","cjjdjjihafhfa","hgacdi","bhff","hdhhbcg","iefbjhgbgdibefjfa","addgjhfhjhiffdehjed","ghhfeacfdbefegegfce","hdihfi","haihafgeif","hjchebigjjbajieifa","hfdccjgjgfdfehacbbh","bhghgfch","ibdjdgjiaijbd","bijcfcibed","di","hjhehcfjefic","jfgdegfbhga","hcgjbhh","ddchjadj","jhjgebcdhfjibjg","iebddjgggaea","afb","ddfafagha","ib","dhifdeejd","ajhdcieifeafba","dehigbbaachff","hjgcigbbdcihcgccfe","gccjbcedjdjeeibcei","ebiajcdfeeh","ggcjahbicgj","cddechhfjjaeabcchfaf","adgaaeeej","hjefijaiecfacc","eee","faegbhejdjha","ddhdg","hajefidebjjdhbgdjdb","gadeegiigfibc","fggfabdbacceefgjdb","fjjj","ab","cbdjeji","cibfchegfhbd","hebifbgjggefhaji","dhbcjdibggjc","gdja","hgjhgfgd","dgjejge","abdagcbhbjbababaeded","bbdiib","fgedjhcehafbi","jijga","bbcbfhcdhffej","jcdhiiiaiiaidjjdd","cggcajccebgj","fbihjeffjdddcbgf","afggaecba","bbgfhaggacc","gadiehbbhihjccajbe","ddjhebbhieaihjbaidgc","fafihjhie","ddiafbgfihhdgajehgdd","ifgaidfge","cf","cjaji","cjcdbch","ahijdfhii","caifgcfehhjhcde","feajgdbebjicehdh","hdjhjibbia","gajbaafiicj","cacibabe","gche","bdjdcahjagejcieddiec","cggjba","ghefdj","jggbjhgj","bfbgbb","bi","ehbfgggaffdcdgj","cb","fbfjebbjfhcbgeaji","dfjeaccc","jdjici","hi","fdcbfiididbbbgefefj","fgbafhijgjffiggjcegi","fb","hhgidgaegjbjffad","faaefgbajggefjiibg","jfccbdeifgdjach","adbdga","fbeicegd","gejhajiijcfgd","feiegagccbfb","jjafbibifddhhdijije","faieafdgfcedbcahbbhc","aai","icchehfbiacaejgfja","ifddcdbe","gidigggfff","ebcgidiecgdc","cbaeabcbfh","biaehabhiagedibbaafd","ibaebfeefci","djgjjah","acajb","jggh","ghigch","gajjh","fcgcgjccjabjjfijbdic","djiaiefdeda","bafhdcjgbjjfgbgahbeb","ie","bfb","bdghgec","agcghjgb","hhiaedaf","fefieaegccic","cjadgiad","ddedgbgccideajhbbagb","ihifcdhhjej","gcdfdabfcj","fcfgdf","cgga","ehicjebjdcig","eaihddgdebjeciih","jfafhaahccigaabbbfd","ieegigedfgbcahjhef","hee","begfgaf","iigfdejfdcjccahghgi","hjhfiaeigihddcj","afafibee","ebejdgfafcihabb","ciddcfebebg","afjgdbbhjebffej","cggiede","ijgjjjdhffhhjjf","ibdcgbhicbid","ihaghcfiaadcfficehaf","achcjfcfcihggh","hdfgeddjaeb","eefdbceffffe","gajfbdadjc","bfig","gfbhbeci","gbbbgheefdbj","ajjbc","ccaabachfdajaj","ghighhigg","bebciebcac","ffiabegfaebficd","eegibjcegiehfdca","hgefhdijdhddbjhjh","ghagbfeehbeddefd","ajhha","ccedbfeeacga","aicgfijfieicaicbied","ajadii","abebaffhjacddahifje","bjeiggebcjieihjj","iadabhfhfj","begghgibcjehaecc","jjedhcgbb","biigijbib","jj","iihedg","feajfbd","ccbgijgbbcj","jejediafbihgbfg","jifgfaadjhaife","dgggbdcd","gbehedbeeji","degdjbbciiijhfe","ifbidigjghhgh","gdcac","hjd","cafdfijcagc","aajdfbibihdgjhfefh","dgcf","eeahibahceacbdddbj","aajhfacbei","fjhifbheechdcbbjaedd","hfgihbfggfdaheiafddi","ijcgj","hehe","gafabicbigddhhccgcjc","fecidefdfcjb","ifbcbcdehefbdi","bhb","ddaeghebgbefhg","eabhegjhh","ejjgbf","faebddaihgfiacji","bacajaddjacfhc","dadfcfagfgjh","bjfaib","hhd","agbhicdagehcgjghdb","jbgeacchibggidda","eibcihfjceijf","bc","jifhhedhebcccihhabf","gjij","ebbicfgfciijihfadfa","hfjg","gjhdehheaafgfabj","fdi","cbbcjac","hhjchjcgjighega","agededgbcbih","acccc","jai","be","ddcge","ag","ifbchceheg","ahhecdhbegabb","hhcfaiijg","chigccebegeichbb","fejjhdaehbaeieahdd","aeadeicb","hj","iaejfcj","feiejbcejbhbciii","fafggaidjechhbec","iahddbfg","hjjehdgigjefcdihgb","jccjgdbidicfajiie","efjaihejgcj","ehhiichfibgfjgfibgeg","ehdgcjdbabj","aaciedigggc","ehidjfiddbd","bgdhgjefgbjae","cedddjiecgc","ije","cdegda","hhigeiafbagd","ia","hficfha","ijicbdgaecg","echgdcgcea","jebc","bhicdc","jijihcddc","adghbaeaeg","eabbhhffjf","djhdaieg","bgidbeedijbeaiejjgcj","gdjcibg","jjhiebecge","jbdiiffbcj","diaefa","iefihdedgjjbejdiicec","effchbafcijahgcgieja","ccebfbbdjbbbhicci","hhfgbciecheg","adgdcifh","bdjihgjg","bdhhiihdfjfjahjhe","fhagfafbdbjabbjjcji","ihagcijfcgbidh","eieeiajjeb","ifhjfebaddi","jcbhajcbegdbhjhge","befeha","iaah","caeecechabegif","ijgbf","fggd","ahfdg","bfbjbdjhfj","diajfcajdffbcaaijhfc","cjcgeacffbibcaf","dbeggeeaggef","ahhcfeebhjagc","gaficcgaegjgdedecb","defhiedddac","ghfdcdegjhdda","ficdbieggcebd","fj","jef","iabhdfbfccchbicdhhfd","ehhidcjcheijehejcag","jigbbb","eicgfbebifh","hegaiicbh","bjcbiehiaghccefdc","bebg","fagcdhdf","cgbghagadbiiefceggdh","jjaedhhccfegfd","ibdg","fheae","dbjfejj","gecje","eabgeaibhibabbdg","fgbh","bj","faejbdicaehdiecd","ea","jefiedbiib","fbhjbabjhbhaaeajfg","jghaabhechjjbff","adefcajaghhae","idigh","eh","bhgffchacgehdaia","ehcheecbijd","bgcihabai","ijaeebce","jgecgfbeadjjgfbcahd","fhhehhcjccdaijihib","fejfbe","jefedbdfcbiaga","fhfbjifjci","fiafbieefghjgbjga","fec","giiecafhedicidachfi","gjhegjiehcibheha","cadjehaacad","eabfbfgcjigiigjj","hchifgbbbgceaahbcbd","eiedjjdbjfbhdjgdai","ide","gafic","aggejcbcj","dhaffihgj","jaecedeiddcichi","baihhjddfbie","aafdadijegehieig","bejihajfcbfbjcaba","diddfgehgccdecjaif","aaadiide","ajcghbhce","bjj","igdefjhbchaeegfg","aa","jeiddcie","gfbjadhi","haghbd","iichbgbdacehhjfhbi","ibdah","ggcbhbdgghjdcfc","iic","feehaej","afcdcjih","hbhafhecjfebe","aigia","hifibfaaegiidga","chdbjhhe","deieedhd","hgfdjahdcbiejebcg","efiifb","daahcbbbjehfe","iijdf","bfifiaceebhfeddd","bhghh","hfeaejcd","bbcfhbgeacijbjfdgib","gji","ebeac","edigdcgihifcejbhbgjd","hifcgjahcagddcaij","agghcgihejafj","aeghfc","bgfaaghhjiiiacigade","fefdj","ahcgjaeg","gjf","dcgfjfgcfab","acfhjghbcgjb","ciccidb","abecfcdfbjdddb","addci","hbacachbhggh","gccibcgcahcgeafhgj","djeccccghidhfgjeaai","ijjed","djcibcgafjieidjacg","gbh","jbda","jgidbigcfhggjda","gbaijdidfaedgdecdg","dfcebaiehbffcegiicgb","ei","bffggjfheaddhf","icjafeaijedgfijjahd","hecafehfdcj","idaieehcg","ejjbfjjgaeb","ahf","ecddidjhcaagjcfbgihf","iiejhidcijabdcfdf","egjeaadhcf","hhjcdcfjdbjjfiae","iiiihhgjgjijjcae","faebigggdcde","ijahief","egeffbg","jeehdfaahafegecdhga","hfbeahba","jaedagchhddhjb","jcagjhifacfegbebdffa","ejbeajegebgij","fagagchjhj","eagbbh","cgcfcccbggaigfddj","agaa","bdjcae","ceaafdiigajg","cjfhgcjfbb","dejhdheeeidggebdjcdf","aichddjgc","ehdjagcdiaiedefdfi","fjdjibgbaffc","gaigcbafgh","jabdaigadjbd","jifdfbgfgaffabd","dceifejdjieaaicegbh","eebhfcgg","eccdgheecajg","bjjacb","eicabbahcjjbiigj","jgefjbbcbgefdeg","iifidfgcadfhihegiabi","bjihfhji","aidedhchejfhej","dihhiccabbjdcied","igihc","aecfd","beggchcdhjfebihehi","aeehhjdg","ccabagdeh","ghedff","hfe","jhed","bchceagbcjjf","hihe","eag","hdjibhhccgdbidif","db","eihfgaghbch","dibgh","aiigcgiecbcedbgfcdfc","djfeihhjibh","fbabbjbeaicbihh","ehijaaheahhcdf","fecgg","jcbf","ejjbadgjidahifhbh","idgfhaiah","dhhaedbbacjibajigd","cbfjieahfh","bjedecib","jgddhcaedejcbdbjec","jebd","bdbjbbe","gaafebcffhaeajfabc","caibj","ef","jiaeccedhabhjfh","gccied","faaidaahabeeicijadcb","ibaecjjaiceaaibcead","gf","gjiabfjhfdgdjeebjheg","cadbgcfjf","gcb","dgiihejbdi","ajifhecegihdbg","afdfaicjaafdgcjab","fbgcbbhafddcgfhggihg","ddchacdaf","jdhca","caghifffcebhfjh","bfceec","iahbchci","fbdaccdehijajjcjjfa","edaggjfhgdegfaagi","becidee","bfaicaidceacjadhgdci","bibaecgfjdaefd","hffhigbiiiacjcf","ijbgjegbghcifij","ejdjieacihgaebigiede","cbhbdjai","jheaffihiebbecd","ccjggdadghadddffdfd","hdjcbjiiieiajfb","djfjfigjbigfdbfdie","fiaabd","aagigibchhgffcdcebdb","gbjghhdjadifg","eagifddgcaejgdfdihfd","ebdeadbh","fhcdhidjfbffgifdce","cbaebeeecaj","baeajgbjgbbai","acbehgii","egiebbdga","hhcbcjjdjaifdaa","jgijhejchdgedcdjie","ii","djd","ghehahieafdcggcgiag","ffia","gdjf","ej","cjei","iebebgadciighiadidb","jjdibfhfigheiadacdjd","iicafdiabbfejda","abbciajffcjdehi","aaa","gjjgibaeggjfce","badabbbchejgaa","abhefigiadgjbafeabja","ceab","ihhccjijeeaabbda","gfebgaidacdecea","fghagjhjhibdhi","ede","geddbffgabac","cgceeebhgifcb","cfdejfe","ghcdjifcibbbbiifi","jbgffjigibbfcejhij","hfhjbcjjcgbhgi","ficbic","bbiedd","dbifabb","cfhgidbgbcigbfagfbj","fhcajbgd","ejdjgajja","gcjd","hafdj","ghjdgfhea","gbificah","dhgea","cfddccig","fcfjd","gbbd","idb","bdbgfdcgfj","fgabfdcegabacbabihj","ddgdgjhbiiihbggici","ec","jfeaehjihbda","icdadijcjchgahajde","fgahifbffcdcdehha","cahhbigjejcjijhg","acjhffgdhfbddg","if","jgicdcideh","ieib","gebifedjbeac","acagecacfhdfe","cehhgbacee","dddgfcfdbdieafbhi","cicfi","cfee","cbgd","edaagffjbdad","ibijhdhedfhhhieeb","jijaech","acajcb","bieegdcjgfgbdd","fi","eedege","iieadehbdbhifj","icccciahaj","caggea","gefe","iiaeefeahbbjbic","aiadjcjhfccidd","hjbhhieehaifddbfb","idjbdbajdfcfcc","eib","gehj","jcbeegahggfbacf","aciiibcebffeffgd","gaabe","ghaejbdhbgeedjfeaih","gfghijjdihbifa","bcbiegi","ijgbabfabbagagg","dgbacigag","ijgghhde","gfighehaidjjcc","efffiagghhbjcfehbae","ibgcj","bjjhbbhajjficbheji","fjagbfddeiddgegdcea","ijeachdacccid","gibg","ajheebafiefiffgc","bbgeegdghfaagdcbcea","ccefbbgbbbdfghgchcd","faciahccecicjffdj","cadbjga","gahidcdabbedb","jcigjbaaefi","fbcgaceaj","hcfgjfccg","chdheeg","jiehbafibbdbehheacc","jeaaa","cbehadcaajjb","ihbfdg","jeiafaediiiajdhbddbb","cidcfadehcfd","gdfecdbjedejijajh","bcifeefcg","accgie","fagdeadebg","fcbbahgbiffgdi","ddacfhadbhafch","dfdgidhjcddf","cadcfafjabeajajae","afbbaeddf","ddgjfifachiiebbhe"});
        System.out.println(result);
    }


    /*
     * @Author zouxiaodong
     * @Description 101 / 134 个通过测试用例,超时
     * @Date 2020/08/06 9:37
     * @Param [words]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     **/
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> resultList = new ArrayList<>(10);
        int len = words.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                String word_i = words[i];
                String word_j = words[j];
                StringBuilder sb_i = new StringBuilder(word_i);
                StringBuilder sb_j = new StringBuilder(word_j);
                if(sb_i.reverse().toString().equals(sb_j.toString())){
                    List<Integer> tempList = new ArrayList<>(2);
                    tempList.add(i);
                    tempList.add(j);
                    resultList.add(tempList);
                    List<Integer> tempList_1 = new ArrayList<>(2);
                    tempList_1.add(j);
                    tempList_1.add(i);
                    resultList.add(tempList_1);
                }else {
                    check(words,i,j,resultList);
                    check(words,j,i,resultList);
                }
            }
        }
        return resultList;
    }

    private void check(String[] words,int i,int j,List<List<Integer>> resultList){
        String w1 = words[i];
        String w2 = words[j];
        StringBuilder sb = new StringBuilder(w1).append(w2);
        if(sb.toString().equals(sb.reverse().toString())){
            List<Integer> tempList = new ArrayList<>(2);
            tempList.add(i);
            tempList.add(j);
            resultList.add(tempList);
        }
    }
}
