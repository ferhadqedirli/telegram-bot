package util;

import java.util.Arrays;

public class MyUtil {
    public static String getPath(String caption) {
        String[] hashTags = getHashTags(caption.toLowerCase());
        String path = "D:\\PRO STUDIO\\";

        for (String hashTag : hashTags) {
            String subPath = getSubPath(hashTag);
            if (subPath != null) {
                path += subPath;
                break;
            }
        }

        return path;
    }

    private static String getSubPath(String hashTag) {
        String subPath = null;
        switch (hashTag) {
            case "#3dпанель":
                subPath = "декор\\3Dпанель\\";
                break;
            case "#шторы":
                subPath = "декор\\шторы\\";
                break;
            case "#другиепредметыинтерьера":
                subPath = "декор\\другиепредметыинтерьера\\";
                break;
            case "#аффреско":
                subPath = "декор\\аффреско\\";
                break;
            case "#багеты":
                subPath = "декор\\багеты\\";
                break;
            case "#вазы":
                subPath = "декор\\вазы\\";
                break;
            case "#декоративныйнабор":
                subPath = "декор\\декоративныйнабор\\";
                break;
            case "#жалюзи":
                subPath = "декор\\жалюзи\\";
                break;
            case "#зеркало":
                subPath = "декор\\зеркало\\";
                break;
            case "#картины":
                subPath = "декор\\картины\\";
                break;
            case "#книги":
                subPath = "декор\\книги\\";
                break;
            case "#ковры":
                subPath = "декор\\ковры\\";
                break;
            case "#лепнина":
                subPath = "декор\\лепнина\\";
                break;
            case "#молдинг":
                subPath = "декор\\молдинг\\";
                break;
            case "#новогоднийдекор":
                subPath = "декор\\новогоднийдекор\\";
                break;
            case "#обувь":
                subPath = "декор\\обувь\\";
                break;
            case "#одежда":
                subPath = "декор\\одежда\\";
                break;
            case "#подушки":
                subPath = "декор\\подушки\\";
                break;
            case "#римскиешторы":
                subPath = "декор\\римскиешторы\\";
                break;
            case "#скульптура":
                subPath = "декор\\скульптура\\";
                break;
            case "#детскаямебель":
                subPath = "детская\\детскаямебель\\";
                break;
            case "#игрушки":
                subPath = "детская\\игрушки\\";
                break;
            case "#шалаш":
                subPath = "детская\\шалаш\\";
                break;
            case "#биокамин":
                subPath = "другиемодели\\биокамин\\";
                break;
            case "#витрина":
                subPath = "другиемодели\\витрина\\";
                break;
            case "#двери":
                subPath = "другиемодели\\двери\\";
                break;
            case "#дверныеручки":
                subPath = "другиемодели\\дверныеручки\\";
                break;
            case "#животные":
                subPath = "другиемодели\\животные\\";
                break;
            case "#камин":
                subPath = "другиемодели\\камин\\";
                break;
            case "#конвектор":
                subPath = "другиемодели\\конвектор\\";
                break;
            case "#крючки":
                subPath = "другиемодели\\крючки\\";
                break;
            case "#лестницы":
                subPath = "другиемодели\\лестницы\\";
                break;
            case "#люди":
                subPath = "другиемодели\\люди\\";
                break;
            case "#магазин":
                subPath = "другиемодели\\магазин\\";
                break;
            case "#медицина":
                subPath = "другиемодели\\медицина\\";
                break;
            case "#музыкальныеинструменты":
                subPath = "другиемодели\\музыкальныеинструменты\\";
                break;
            case "#окна":
                subPath = "другиемодели\\окна\\";
                break;
            case "#перегородка":
                subPath = "другиемодели\\перегородка\\";
                break;
            case "#печь":
                subPath = "другиемодели\\печь\\";
                break;
            case "#потолок":
                subPath = "другиемодели\\потолок\\";
                break;
            case "#радиатор":
                subPath = "другиемодели\\радиатор\\";
                break;
            case "#раздвижныедвери":
                subPath = "другиемодели\\раздвижныедвери\\";
                break;
            case "#ресепшен":
                subPath = "другиемодели\\ресепшен\\";
                break;
            case "#ресторан":
                subPath = "другиемодели\\ресторан\\";
                break;
            case "#салонкрасоты":
                subPath = "другиемодели\\салонкрасоты\\";
                break;
            case "#спорт":
                subPath = "другиемодели\\спорт\\";
                break;
            case "#транспорт":
                subPath = "другиемодели\\транспорт\\";
                break;
            case "#фурнитура":
                subPath = "другиемодели\\фурнитура\\";
                break;
            case "#электрика":
                subPath = "другиемодели\\электрика\\";
                break;
            case "#вытяжка":
                subPath = "кухни\\вытяжка\\";
                break;
            case "#декордлякухни":
                subPath = "кухни\\декордлякухни\\";
                break;
            case "#духовка":
                subPath = "кухни\\духовка\\";
                break;
            case "#еданапитки":
                subPath = "кухни\\еданапитки\\";
                break;
            case "#кухня":
                subPath = "кухни\\кухня\\";
                break;
            case "#кухоннаятехника":
                subPath = "кухни\\кухоннаятехника\\";
                break;
            case "#мойка":
                subPath = "кухни\\мойка\\";
                break;
            case "#посуда":
                subPath = "кухни\\посуда\\";
                break;
            case "#фрукты":
                subPath = "кухни\\фрукты\\";
                break;
            case "#холодильник":
                subPath = "кухни\\холодильник\\";
                break;
            case "#банкетка":
                subPath = "мебель\\банкетка\\";
                break;
            case "#барныйстул":
                subPath = "мебель\\барныйстул\\";
                break;
            case "#гардероб":
                subPath = "мебель\\гардероб\\";
                break;
            case "#диван":
                subPath = "мебель\\диван\\";
                break;
            case "#журнальныйстол":
                subPath = "мебель\\журнальныйстол\\";
                break;
            case "#комод":
                subPath = "мебель\\комод\\";
                break;
            case "#консоль":
                subPath = "мебель\\консоль\\";
                break;
            case "#кресло":
                subPath = "мебель\\кресло\\";
                break;
            case "#кресломешок":
                subPath = "мебель\\кресломешок\\";
                break;
            case "#офис":
                subPath = "мебель\\офис\\";
                break;
            case "#офиснаямебель":
                subPath = "мебель\\офиснаямебель\\";
                break;
            case "#подвесноекресло":
                subPath = "мебель\\подвесноекресло\\";
                break;
            case "#прихожая":
                subPath = "мебель\\прихожая\\";
                break;
            case "#пуф":
                subPath = "мебель\\пуф\\";
                break;
            case "#рабочееместо":
                subPath = "мебель\\рабочееместо\\";
                break;
            case "#софа":
                subPath = "мебель\\софа\\";
                break;
            case "#стеллаж":
                subPath = "мебель\\стеллаж\\";
                break;
            case "#столик":
                subPath = "мебель\\столик\\";
                break;
            case "#столстул":
                subPath = "мебель\\столстул\\";
                break;
            case "#столы":
                subPath = "мебель\\столы\\";
                break;
            case "#стул":
                subPath = "мебель\\стул\\";
                break;
            case "#стулья":
                subPath = "мебель\\стулья\\";
                break;
            case "#твстенка":
                subPath = "мебель\\твстенка\\";
                break;
            case "#туалетныйстолик":
                subPath = "мебель\\туалетныйстолик\\";
                break;
            case "#тумба":
                subPath = "мебель\\тумба\\";
                break;
            case "#шкафы":
                subPath = "мебель\\шкафы\\";
                break;
            case "#кровать":
                subPath = "мебель\\кровать\\";
                break;
            case "#бра":
                subPath = "освещение\\бра\\";
                break;
            case "#встроенный":
                subPath = "освещение\\встроенный\\";
                break;
            case "#гирлянда":
                subPath = "освещение\\гирлянда\\";
                break;
            case "#люстры":
                subPath = "освещение\\люстры\\";
                break;
            case "#напольный":
                subPath = "освещение\\напольный\\";
                break;
            case "#настольная":
                subPath = "освещение\\настольная\\";
                break;
            case "#неон":
                subPath = "освещение\\неон\\";
                break;
            case "#подвес":
                subPath = "освещение\\подвес\\";
                break;
            case "#подвесной":
                subPath = "освещение\\подвесной\\";
                break;
            case "#потолочный":
                subPath = "освещение\\потолочный\\";
                break;
            case "#технический":
                subPath = "освещение\\технический\\";
                break;
            case "#торшеры":
                subPath = "освещение\\торшеры\\";
                break;
            case "#точки":
                subPath = "освещение\\точки\\";
                break;
            case "#треки":
                subPath = "освещение\\треки\\";
                break;
            case "#уличный":
                subPath = "освещение\\уличный\\";
                break;
            case "#букеты":
                subPath = "растения\\букеты\\";
                break;
            case "#деревья":
                subPath = "растения\\деревья\\";
                break;
            case "#комнатныерастения":
                subPath = "растения\\комнатныерастения\\";
                break;
            case "#кусты":
                subPath = "растения\\кусты\\";
                break;
            case "#мох":
                subPath = "растения\\мох\\";
                break;
            case "#сухостой":
                subPath = "растения\\сухостой\\";
                break;
            case "#трава":
                subPath = "растения\\трава\\";
                break;
            case "#уличные":
                subPath = "растения\\уличные\\";
                break;
            case "#фитостены":
                subPath = "растения\\фитостены\\";
                break;
            case "#баня":
                subPath = "санузел\\баня\\";
                break;
            case "#биде":
                subPath = "санузел\\биде\\";
                break;
            case "#ванна":
                subPath = "санузел\\ванна\\";
                break;
            case "#декордляванны":
                subPath = "санузел\\декордляванны\\";
                break;
            case "#душ":
                subPath = "санузел\\душ\\";
                break;
            case "#душевая":
                subPath = "санузел\\душевая\\";
                break;
            case "#кнопкасмыва":
                subPath = "санузел\\кнопкасмыва\\";
                break;
            case "#мебельдляванны":
                subPath = "санузел\\мебельдляванны\\";
                break;
            case "#полотенца":
                subPath = "санузел\\полотенца\\";
                break;
            case "#полотенцесушитель":
                subPath = "санузел\\полотенцесушитель\\";
                break;
            case "#прачечная":
                subPath = "санузел\\прачечная\\";
                break;
            case "#раковина":
                subPath = "санузел\\раковина\\";
                break;
            case "#смеситель":
                subPath = "санузел\\смеситель\\";
                break;
            case "#стиральнаямашина":
                subPath = "санузел\\стиральнаямашина\\";
                break;
            case "#сушка":
                subPath = "санузел\\сушка\\";
                break;
            case "#трап":
                subPath = "санузел\\трап\\";
                break;
            case "#умывальники":
                subPath = "санузел\\умывальники\\";
                break;
            case "#унитаз":
                subPath = "санузел\\унитаз\\";
                break;
            case "#фурнитурадляванной":
                subPath = "санузел\\фурнитурадляванной\\";
                break;
            case "#халат":
                subPath = "санузел\\халат\\";
                break;
            case "#скрипты":
                subPath = "скрипты\\скрипты\\";
                break;
            case "#hdri":
                subPath = "текстуры\\HDRI\\";
                break;
            case "#акрил":
                subPath = "текстуры\\акрил\\";
                break;
            case "#бетон":
                subPath = "текстуры\\бетон\\";
                break;
            case "#декоративнаяштукатурка":
                subPath = "текстуры\\декоративнаяштукатурка\\";
                break;
            case "#дерево":
                subPath = "текстуры\\дерево\\";
                break;
            case "#жидкость":
                subPath = "текстуры\\жидкость\\";
                break;
            case "#камень":
                subPath = "текстуры\\камень\\";
                break;
            case "#материалы":
                subPath = "текстуры\\материалы\\";
                break;
            case "#материал":
                subPath = "текстуры\\материалы\\";
                break;
            case "#кафель":
                subPath = "текстуры\\кафель\\";
                break;
            case "#кирпич":
                subPath = "текстуры\\кирпич\\";
                break;
            case "#кожа":
                subPath = "текстуры\\кожа\\";
                break;
            case "#ламинат":
                subPath = "текстуры\\ламинат\\";
                break;
            case "#металл":
                subPath = "текстуры\\металл\\";
                break;
            case "#обои":
                subPath = "текстуры\\обои\\";
                break;
            case "#органика":
                subPath = "текстуры\\органика\\";
                break;
            case "#панорама":
                subPath = "текстуры\\панорама\\";
                break;
            case "#паркет":
                subPath = "текстуры\\паркет\\";
                break;
            case "#пластик":
                subPath = "текстуры\\пластик\\";
                break;
            case "#плитка":
                subPath = "текстуры\\плитка\\";
                break;
            case "#пол":
                subPath = "текстуры\\пол\\";
                break;
            case "#стекло":
                subPath = "текстуры\\стекло\\";
                break;
            case "#стены":
                subPath = "текстуры\\стены\\";
                break;
            case "#ткань":
                subPath = "текстуры\\ткань\\";
                break;
            case "#разное":
                subPath = "текстуры\\разное\\";
                break;
            case "#аудиотехника":
                subPath = "техника\\аудиотехника\\";
                break;
            case "#бойлер":
                subPath = "техника\\бойлер\\";
                break;
            case "#бытоваятехника":
                subPath = "техника\\бытоваятехника\\";
                break;
            case "#вентилятор":
                subPath = "техника\\вентилятор\\";
                break;
            case "#выключатели":
                subPath = "техника\\выключатели\\";
                break;
            case "#компьютеры":
                subPath = "техника\\компьютеры\\";
                break;
            case "#кондиционер":
                subPath = "техника\\кондиционер\\";
                break;
            case "#пылесос":
                subPath = "техника\\пылесос\\";
                break;
            case "#розетки":
                subPath = "техника\\розетки\\";
                break;
            case "#телевизор":
                subPath = "техника\\телевизор\\";
                break;
            case "#телефон":
                subPath = "техника\\телефон\\";
                break;
            case "#электроника":
                subPath = "техника\\электроника\\";
                break;
            case "#автомобиль":
                subPath = "экстерьер\\автомобиль\\";
                break;
            case "#барбекю":
                subPath = "экстерьер\\барбекю\\";
                break;
            case "#бассейн":
                subPath = "экстерьер\\бассейн\\";
                break;
            case "#брусчатка":
                subPath = "экстерьер\\брусчатка\\";
                break;
            case "#город":
                subPath = "экстерьер\\город\\";
                break;
            case "#детскаяплощадка":
                subPath = "экстерьер\\детскаяплощадка\\";
                break;
            case "#здание":
                subPath = "экстерьер\\здание\\";
                break;
            case "#кафе":
                subPath = "экстерьер\\кафе\\";
                break;
            case "#ковка":
                subPath = "экстерьер\\ковка\\";
                break;
            case "#кофейня":
                subPath = "экстерьер\\кофейня\\";
                break;
            case "#городскаясреда":
                subPath = "экстерьер\\городскаяСреда\\";
                break;
            case "#элементфасада":
                subPath = "экстерьер\\элементФасада\\";
                break;
            case "#деталиокружающейсреды":
                subPath = "экстерьер\\деталиОкружающейСреды\\";
                break;
            case "#барбекюигриль":
                subPath = "экстерьер\\барбекюИГриль\\";
                break;
            case "#ланшафт":
                subPath = "экстерьер\\ланшафт\\";
                break;
            case "#ограждение":
                subPath = "экстерьер\\ограждение\\";
                break;
            case "#сетка":
                subPath = "экстерьер\\сетка\\";
                break;
            case "#фасад":
                subPath = "экстерьер\\фасад\\";
                break;
            default:
                break;
        }
        return subPath;
    }

    private static String[] getHashTags(String caption) {
        return Arrays.stream(caption.split("[ \n]"))
                .filter(s -> s.startsWith("#"))
                .toArray(String[]::new);
    }

}
