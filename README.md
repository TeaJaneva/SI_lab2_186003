# Втора лабораториска вежба по Софтверско инженерство
Tеа Јанева, 186003

1. Група на код: 
-Група на код 3

2. Control Flow Graph

  ![ControlGraph](https://user-images.githubusercontent.com/63406143/84568685-64b21400-ad81-11ea-979d-173951b6fe99.jpg)


3. Цикломатска комплексност
Цикломатската комплексност е 10. Може да ја добиеме P+1, каде што P е бројот на предикатни јазли. Во случајoв P=9, па цикломатската комплексност изнесува 10.  Тоа се јазлите 1, 3, 5 ,7, 10.2, 11, 13, 15, 17. 


4. Тест случаи според критериумот Every statement
  1) user=null, allUsers=x
  2) user=[null, x, x], allUsers=x
  3) user=[tea, tea, x], allUsers=x
  4) user=[x, tea, x], allUsers=x
  5) user=[x, Tea136()*, x],  allUsers=x
  6) user=[x, tea136()*, x],  allUsers=x

![every_statement](https://user-images.githubusercontent.com/63406143/84568728-b3f84480-ad81-11ea-9dcf-c64678c1971d.PNG)


На сликата може да се види како се избрани условите и кој дел ќе го исполнуваат. Што ќе се земе за листата, не менува во извршување, бидејќи никаде во кодот на функцијата не е искористена. Кога ќе земеме за корисник null, го опфаќаме првиот услов и се исполнуваат 1,2,20. Корисник се состои од 3 дела бидејќи е референца од класата User, па во останатите случаи ќе се менуваат овие делови (user, password, email).  За да се испита случајот каде нема доволно информации, земам за корисникот да имаме null во името (условот е со или, па доволно е да го испитаме само кога едниот ќе биде исполнет), па се поминуваат 1,3,4,20. За следните 2 случаи земам ист пример (истовремено не одговара на 2та услови, но ги земам како посебни случаеви бидејќи кога ќе падне на првиот услов, нема да ги помине деловите на вториот услов). Првиот е кога името не треба да се содржи во лозинката, а вториот е кога лозинката е помала од 8 карактери. Се изминуваат 1,3,5,6,20 и 1,3,5,7,8,20. Следниот случај е кога се работи за точна лозинка, односно пример во кој не би паднале никаде и единствениот случај во кој би стигнале до return true. Лозинката има и голема буква, и броеви и специјални карактери. Со ова се изминуваат 1,3,5,7,9,10.1,10.2,10.3,11,12,13,14,15, 16,17,19,20. Останува уште последниот услов кој е или услов па доволно е да провериме само за еден од случаевите.  Во примерот земам да нема голема буква, односно за лозинка земам tеа136()*, па се поминуваат 1,3,5,7,9,10.1,10.2,10.3,11,12,13,15,16,17,18,20, со што се изминати сите можни ситуации.


5. Тест случаи според Multiple condition критериумот

  1) if (user.getUsername()==null || user.getPassword()==null)
    -T/x
    -F/T
    -F/F

  2) if (!digit || !upper || !special)
    -T/x/x
    -F/T/x
    -F/F/T
    -F/F/F
    
 ![multiple](https://user-images.githubusercontent.com/63406143/84568788-1bae8f80-ad82-11ea-88b1-9b6492a96fea.PNG)


Имаме 2 случаи со Multiple condition. Првиот случај if(user.getUsername()==null || user.getPassword()==null), каде што имаме 2 услови поврзани со или, што значи имаме 3 опции: кога првиот ќе е true, кога првиот ќе е false, а вториот true, и последниот е кога двата ќе се false со што нема да се исполни ниту еден од условите и нема да влеземе во овој if. Како тест примери во првиот случај земам да немам информации за ниту еден од 3те делови на корисникот, во вториот случај земам да има име, но не и лозинка, и последниот случај е да имам се (адресата не е битна во условите). Вториот случај е if(!digit || !upper || !special), каде што имаме 3 услови поврзани со или. Digit, upper и special може да бидат  true или false во зависност од тоа дали во лозинката има броеви, знаци или големи букви. Првата опција е true/x/x, каде што за тест пример земам лозинката да нема броеви, потоа следи false/true/x за кој земам лозинката да има броеви, но да нема големи букви. Третата опција е да има броеви и големи букви, но да нема специјални знаци и последната е да ги има сите 3, со што нема да се исполни ниту еден од условите и не се влегува во if.
