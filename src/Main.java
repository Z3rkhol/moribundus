import java.io.*;
import java.util.*;

public class Main {
    private static final String FILE_NAME = "absence_counter.txt";

    public static void main(String[] args) {

        String[] excuses = {
                "Můj křeček explodoval.",
                "Byl(a) jsem unesen(a) mimozemšťany.",
                "Můj počítač shořel.",
                "Omylem jsem zamkl(a) klíče ve skříni i se sebou.",
                "Zaspal(a) jsem kvůli tomu, že mi budík odmítl spolupracovat.",
                "Můj pes snědl moje domácí úkoly a pak mi je hodil zpátky.",
                "Včera jsem se probudil(a) v jiné dimenzi a trvalo mi chvíli se vrátit.",
                "Moje auto se proměnilo v dýni přesně o půlnoci.",
                "Moje babička měla narozeniny… podruhé tento měsíc.",
                "Musel(a) jsem bojovat s obří slepicí na cestě do školy.",
                "Měl(a) jsem alergickou reakci na vlastní lenost.",
                "Můj soused mi omylem zamknul dveře zvenčí.",
                "Ztratil(a) jsem se v supermarketu na celý den.",
                "Můj kočka se rozhodla spát na mém obličeji a já nemohl(a) dýchat.",
                "Snědl(a) jsem něco podezřelého a teď vidím zvuky.",
                "Musel(a) jsem vyhrát závod o přežití s medvědem.",
                "Moje GPS mě vedla do jiného města.",
                "Byl(a) jsem v zajetí vlastního gauče.",
                "Pořád jsem čekal(a), až přestane pršet, ale nikdy nepřestalo.",
                "Můj internet se rozhodl mít volný den.",
                "Musel(a) jsem zastavit apokalypsu na poslední chvíli.",
                "Můj křeček mě vyzval na šachový souboj a nemohl(a) jsem odmítnout.",
                "Můj dům byl náhle prohlášen za turistickou atrakci a musel(a) jsem dělat průvodce.",
                "Stal(a) jsem se obětí nadpřirozeného prokletí.",
                "Moje auto dostalo existenciální krizi a odmítlo nastartovat.",
                "Můj soused začal hrát na bubny ve 3 ráno a já nemohl(a) spát.",
                "Uvízl(a) jsem ve výtahu s partou klaunů.",
                "Musel(a) jsem se účastnit nouzového rodinného srazu v Antarktidě.",
                "Můj papoušek se naučil sprostá slova a odmítal přestat.",
                "Moje rybičky plánovaly útěk a musel(a) jsem je zastavit.",
                "Můj stín se rozhodl jít na dovolenou beze mě.",
                "Ztratil(a) jsem se na cestě do koupelny.",
                "Můj telefon dostal vir a začal mluvit zpětně.",
                "Moje rostliny se rozhodly sabotovat můj budík.",
                "Zemská gravitace na chvíli přestala fungovat.",
                "Musel(a) jsem pomoct sousedovi chytit uprchlé kuře.",
                "Na mé auto spadla létající pizza.",
                "Můj domácí robot se vzbouřil a odmítl mě pustit ven.",
                "Přišel(a) jsem pozdě, protože jsem se ztratil(a) v zóně snění.",
                "Moje kytka mě hypnotizovala a zapomněl(a) jsem vyjít z domu.",
                "Musel(a) jsem zachránit svět před tajnou organizací z podzemí.",
                "Můj čaj měl tak hluboký filozofický význam, že jsem přemýšlel(a) příliš dlouho.",
                "Uvízl(a) jsem na toaletě kvůli nečekanému setkání s pavoukem.",
                "Moje ponožky se rozhodly utéct a já je musel(a) honit.",
                "Můj kalendář měl špatné datum a žil jsem včerejškem.",
                "Moje kočka přistála na klávesnici a smazala všechny mé plány.",
                "Časoprostorová anomálie mě poslala zpět o dvě hodiny.",
                "Moje domácí úkoly spontánně shořely ve světle ranního slunce.",
                "Přes noc jsem se proměnil(a) v netopýra a čekal(a) jsem na proměnu zpět.",
                "Můj pes chtěl jít na procházku, ale trvala 6 hodin.",
                "Přestal mi fungovat budík, protože ho sabotoval sousedův papoušek.",
                "Můj zrcadlový obraz mě vyzval na souboj a nemohl(a) jsem odmítnout.",
                "Byl(a) jsem unesen(a) podvodní civilizací a učil(a) jsem se jejich jazyk.",
                "Přišel(a) jsem pozdě, protože jsem musel(a) dokončit hru na šachovnici vesmíru.",
                "Můj dům se přes noc přesunul do paralelní dimenze.",
                "Moje mikrovlnka začala vysílat šifrované zprávy a já je musel(a) rozluštit.",
                "Můj pes začal meditovat a nechtěl přestat.",
                "Moje kočka přistála v mých plánech a roztrhala je na kusy.",
                "Můj stůl se sám přetvořil na plovoucí ostrov.",
                "Zavřel(a) jsem se do koupelny a musel(a) jsem čekat na návrat světla.",
                "Na cestě do školy jsem potkal(a) ztracený UFO a pomohl(a) mu najít cestu domů.",
                "Včera jsem byl(a) součástí bitvy s draky na hřbitově.",
                "Můj internet byl napaden viry z paralelní dimenze.",
                "Můj počítač se rozhodl hrát sám se sebou a nešlo ho vypnout.",
                "Chtěl(a) jsem se dostat do školy, ale místo toho jsem skončil(a) ve hře na sloní stezce.",
                "Můj pes ztratil schopnost chodit a teď se pohybuje jenom po kouzelných stezkách.",
                "Můj dům začal v noci zpívat staré balady a nemohl(a) jsem spát.",
                "Můj šatník vytvořil vlastní pravidla pro oblékání.",
                "Ztratil(a) jsem se v kouzelném lese a trvalo mi to dva dny, než jsem se dostal(a) zpět.",
                "Můj telefon se rozhodl stát mým osobním koučem pro meditaci.",
                "Můj stín se rozhodl opustit mě a já musel(a) znovu získat svou energii.",
                "Moje postel mě vtáhla zpět a už mě nechtěla pustit.",
                "Můj klavír začal hrát sám pro sebe, ale já jsem nemohl(a) přestat poslouchat.",
                "Ztratil(a) jsem svou paměť při hledání klíčů, ale vzpomněl(a) jsem si, že je mám v kapse.",
                "Moje žárovky začaly bliknout do rytmu hudby a nemohl(a) jsem se soustředit.",
                "Můj soused začal hrát na klavír do noci a já nemohl(a) spát.",
                "Můj počítač mě obvinil z porušení pravidel a odmítl fungovat.",
                "Můj pes se rozhodl, že už nechce být pes, ale páv, a teď se předvádí na zahradě.",
                "Moje auto přestalo fungovat, protože se rozhodlo, že dnes je jeho den volna.",
                "Můj stůl se rozhodl být lodí a vyplul na oceán mých myšlenek.",
                "Moje kočka si zabavila všechny moje domácí úkoly a teď se jimi baví.",
                "Můj mobil si založil vlastní účty na sociálních sítích a teď už nemůžu zkontrolovat svoje zprávy.",
                "Chtěl(a) jsem si vyčistit zuby, ale zubní pasta se rozhodla mít dovolenou.",
                "Můj pes se rozhodl, že chce být kočka a začal se chovat podivně.",
                "Byl(a) jsem unesen(a) týmem superhrdinů a pomáhal(a) jim zachránit svět.",
                "Moje auto se rozhodlo prozkoumat městskou džungli a já jsem ho musel(a) zachránit.",
                "Můj mobil mi poslal zprávu, že jsem zapomněl(a) na své povinnosti.",
                "Našel(a) jsem nový způsob, jak cestovat v čase, ale vrátil(a) jsem se o dvě hodiny později.",
                "Můj dům mi poslal varování, že je v karanténě kvůli nekontrolovatelným výbuchům špaget.",
                "Můj počítač odmítl přijmout moji žádost o práci a začal dělat vlastní projekt.",
                "Moje rostliny uspořádaly protest proti zalévání a odmítaly růst.",
                "Přestal(a) jsem se soustředit, protože jsem začal(a) rozumět jazyku mých bot.",
                "Můj pes mi poslal pohlednici z dovolené, ale já jsem zapomněl(a) kam ji poslal.",
                "Chtěl(a) jsem si zajít na oběd, ale moje lžíce si udělala volno.",
                "Můj kočka zorganizovala turnaj ve hře o trůny, a já musel(a) být její porotce.",
                "Moje žárovky začaly v noci žít vlastním životem a já nemohl(a) spát.",
                "Moje židle se rozhodla stát taneční partnerkou mého stolu a odmítla mě pustit.",
                "Můj pes začal číst filosofické knihy a teď mi vysvětluje, jak žít.",
                "Můj pes začal číst filosofické knihy a teď diskutuje o smyslu života.",
                "Moje kytka mě obvinila z nedostatku pozornosti a teď odmítá růst.",
                "Můj telefon se připojil k tajné organizaci a odmítl mi dávat informace.",
                "Včera jsem se dostal(a) do časové smyčky a celý den jsem dělal(a) stejnou věc.",
                "Můj stůl se rozhodl být uměleckým dílem a odmítl mě pustit k práci.",
                "Můj počítač si začal sám aktualizovat software a zapomněl mi říct, kdy to skončí.",
                "Můj pes se rozhodl, že už nebude běhat, ale raději bude meditovat.",
                "Moje auto si našlo nový směr života a rozhodlo se jet na dovolenou do hor.",
                "Moje kočka odmítá jíst, dokud jí neukážu nový film o kočkách.",
                "Chtěl(a) jsem napsat úkol, ale moje klávesnice začala psát básně.",
                "Ztratil(a) jsem se ve vlastním domě, protože jsem zapomněl(a), kde je vchod.",
                "Můj křeček začal číst knihy o kvantové fyzice a teď mi vysvětluje teorii relativity.",
                "Moje kočka se rozhodla, že mě naučí, jak meditovat, a odmítla mě pustit k práci.",
                "Můj telefon mi poslal SMS, že mám problémy se soustředěním, a teď už nedokážu nic dělat.",
                "Přes noc jsem se proměnil(a) v hada a teď se snažím vrátit zpět.",
                "Můj pes se rozhodl, že bude vegan, a teď se mnou sdílí své recepty.",
                "Můj dům začal zpívat karaoke a já jsem nemohl(a) najít ovladač.",
                "Ztratil(a) jsem se na cestě do školy, protože mě zavedla nesprávná mapa.",
                "Můj stůl začal skákat po místnosti, protože měl nový tanec.",
                "Moje kočka mi poslala dopis, že se chce stát astronautkou.",
                "Můj pes se rozhodl, že bude pracovat z domova, a já jsem musel(a) upravit plán.",
                "Můj počítač mě obvinil, že ho používám špatně, a začal mi blokovat programy.",
                "Chtěl(a) jsem se podívat na zprávy, ale televizor začal vysílat vlastní verzi reality.",
                "Můj telefon si založil vlastní sociální síť a začal tam postovat všechny moje fotky.",
                "Moje kytky mě obvinily z toho, že jsem je nezaléval(a) správně, a teď bojkotují růst.",
                "Můj stín se rozhodl, že půjde na procházku sám, a já jsem ho musel(a) hledat.",
                "Můj pes začal malovat obrazy a teď se mě snaží učit, jak být umělecký.",
                "Můj počítač si přečetl všechny moje e-maily a teď mi dává rady k životu.",
                "Našel(a) jsem kouzelnou knihu, která mi přikázala, abych ji nedával(a) zpátky na poličku.",
                "Můj dům se začal přetvářet na bludiště a já jsem se ztratil(a) v chodbičkách.",
                "Moje kočka se rozhodla začít podnikat a teď mi dává podnikatelské rady.",
                "Můj pes ztratil všechny své hračky a začal hledat nové v zahradě.",
                "Moje žárovky začaly svítit do rytmu hudby, ale já jsem zapomněl(a), jakou písničku to bylo.",
                "Můj mobil se rozhodl být zodpovědný a zablokoval všechny moje notifikace.",
                "Můj stůl se proměnil v loď a odmítl mě pustit zpět na pevninu.",
                "Můj počítač si založil vlastní časový plán a zablokoval všechny moje důležité projekty.",
                "Moje kočka začala hrát na klavír a teď jsem ztratil(a) všechny svoje noty.",
                "Můj pes začal přemýšlet o hlubších věcech a teď odmítá běhat za míčem.",
                "Moje auto se rozhodlo studovat filozofii a přestalo jezdit.",
                "Můj dům začal měnit místnosti podle nálady a já jsem se ztratil(a) ve své vlastní kuchyni.",
                "Můj telefon mi ukázal nový svět, ale já jsem se v něm ztratil(a).",
                "Můj stůl mě obvinil, že jsem mu nevěnoval(a) dostatek pozornosti a teď je z něj stávkový výbor.",
                "Moje kočka přistála na klávesnici a napsala knihu o vlastních dobrodružstvích.",
                "Můj pes se rozhodl stát jogínem a teď mi ukazuje nové pozice.",
                "Můj počítač začal zpívat operu a já jsem se snažil(a) být součástí toho představení.",
                "Chtěl(a) jsem si udělat kávu, ale kávovar se rozhodl stát baristou a odmítl mě obsloužit.",
                "Moje auto si myslí, že je v muzeu a odmítá jet dál.",
                "Můj stůl se rozhodl být sochou a teď mě odmítá pustit k psaní.",
                "Moje kočka si založila vlastní kanál na YouTube a už má více sledovatelů než já.",
                "Můj telefon mě obvinil z toho, že používám špatné aplikace, a začal mi blokovat všechny.",
                "Můj pes se rozhodl, že chce být influencerem a začal mi dělat reklamu na kostičky.",
                "Můj počítač si založil vlastní internetovou stránku a odmítl mě pustit na žádné jiné.",
                "Chtěl(a) jsem si lehnout na postel, ale postel mě políbila na čelo a odmítla mě pustit.",
                "Můj stůl začal tančit breakdance a odmítl mě pustit zpět ke své práci.",
                "Můj pes mi poslal e-mail, že chce jít na procházku, ale nemám čas.",
                "Moje auto se rozhodlo stát uměleckým dílem a odmítlo jet dál.",
                "Moje kočka mě přeměnila v kámen a musel(a) jsem čekat, až se vrátím zpět.",
                "Ztratil(a) jsem klíče, protože mi je ukradl můj odraz v zrcadle.",
                "Moje auto se rozhodlo stát se pojízdným zámkem a zůstalo v garáži.",
                "Byl(a) jsem unesen(a) stvůrami z jiné dimenze a učil(a) jsem je tančit.",
                "Moje ponožky se rozhodly mít dovolenou a já jsem musel(a) jít naboso.",
                "Ztratil(a) jsem se v labyrintu vlastní kuchyně a nemohl(a) najít cestu ven.",
                "Můj telefon začal mluvit sám za sebe a odmítal mě poslouchat.",
                "Moje kočka odmítla vyjít z domu, protože venku bylo příliš mnoho slunečního světla.",
                "Musel(a) jsem vzít na vědomí, že moje auto se připojilo k tajné organizaci.",
                "Stal(a) jsem se neviditelným na celý den a nemohl(a) najít způsob, jak se vrátit.",
                "Můj stůl si začal psát vlastní deník a odmítal mě pustit k němu.",
                "Můj pes se stal guruem jógy a odmítal mě pustit na procházku.",
                "Moje kočka mě přivedla na myšlenku filozofického zkoumání světa, a zapomněl(a) jsem na čas.",
                "Byl(a) jsem pohlcen(a) kouzlem zpomalení času a všechno trvalo věčnost.",
                "Moje auto se proměnilo v raketu a vzlétlo na Mars.",
                "Ztratil(a) jsem svoji paměť, protože jsem si ji zapomněl(a) doma.",
                "Moje klávesnice se rozhodla napsat vlastní básně, místo abych napsal úkol.",
                "Včera jsem se rozhodl(a) vést diskusi se svým zrcadlem, místo abych se dostal(a) do školy.",
                "Můj počítač začal hledat pravdu o vesmíru a odmítal mě pustit ke své práci.",
                "Můj pes si usmyslel, že dnes bude malířem a zamazal všechny moje dokumenty.",
                "Ztratil(a) jsem se v bludišti myšlenek a nemohl(a) najít cestu zpět.",
                "Můj mobil mi řekl, že má volno a že nemůže být mým asistentem.",
                "Zaspal(a) jsem, protože mi v noci přišel email, který jsem musel(a) urgentně přečíst.",
                "Můj stín mě zradil a rozhodl se jít na dovolenou beze mě.",
                "Můj klavír začal vydávat zvuky, které mi znemožnily koncentraci.",
                "Musel(a) jsem naplánovat záchrannou akci pro svého oblíbeného superhrdinu.",
                "Můj pes si přál být astronautem a já jsem musel(a) podstoupit vesmírný výcvik.",
                "Moje kočka se stala kardinálem a začala vést mši.",
                "Můj stůl dostal amnézii a zapomněl, jak fungovat.",
                "Na cestě do školy jsem potkal(a) vesmírnou loď a musel(a) se jí ukázat jako pilot.",
                "Můj internet si vzal dovolenou, aby se podíval na jiné dimenze.",
                "Ztratil(a) jsem se ve světě, kde byl vše převrácený, a nemohl(a) jsem najít cestu zpět.",
                "Moje žárovky začaly zpívat operu a já jsem musel(a) být jejich hlasem.",
                "Ztratil(a) jsem všechny své klíče, protože mi je ukradl čas.",
                "Včera jsem byl(a) pozván(a) na večeři do paralelní dimenze a vrátil(a) jsem se pozdě.",
                "Zamknul(a) jsem se ve své vlastní hlavě a zapomněl(a) na čas.",
                "Našel(a) jsem tajnou skrýš ve své koupelně a musel(a) ji prozkoumat.",
                "Ztratil(a) jsem svůj vlastní stín, protože jsem ho nechal(a) doma.",
                "Moje auto se rozhodlo prozkoumat svět a odmítlo mě vzít zpátky.",
                "Byl(a) jsem vtažen(a) do paralelní reality, kde byl každý den svátek.",
                "Ztratil(a) jsem veškerý smysl pro čas, protože jsem začal(a) přemýšlet o filozofických otázkách.",
                "Můj pes začal mluvit cizími jazyky a já jsem musel(a) najít tlumočníka.",
                "Můj mobil se připojil k tajné vládní organizaci a odmítal mě informovat o zprávách.",
                "Moje kočka mi ukradla všechny plány a teď je používá pro svůj vlastní život.",
                "Ztratil(a) jsem se na vlastní oslavě narozenin.",
                "Můj dům začal promlouvat do mého svědomí a odmítal mě pustit ven.",
                "Včera jsem byl(a) vtažen(a) do ztracené civilizace a stihl(a) jsem se vrátit až dnes.",
                "Ztratil(a) jsem svůj orientační smysl kvůli příliš hlubokým úvahám.",
                "Můj telefon se rozhodl udělat svou vlastní verzi mého života a teď žije svůj vlastní příběh.",
                "Byl(a) jsem vtažen(a) do virtuálního světa a nemohl(a) se dostat ven.",
                "Můj pes ztratil schopnost štěkat a začal se chovat jako kočka.",
                "Ztratil(a) jsem všechny své plány, protože mi je ukradl můj vlastní stín.",
                "Moje kočka mi řekla, že není moje kočka, a teď se tváří jako pes.",
                "Ztratil(a) jsem se v obchodě s obuví, kde všechny boty začaly mít své vlastní názory.",
                "Včera jsem se ocitl(a) ve světě, kde všechny knihy začaly mluvit.",
                "Moje auto se rozhodlo stát se balónem a odletělo na dovolenou.",
                "Ztratil(a) jsem se na cestě domů, protože mě GPS zavedla na cizí planetu.",
                "Moje žárovky se staly senzory pro záznam času a přestaly fungovat.",
                "Můj mobil se rozhodl, že je jeho den volna, a nechal mě na holičkách.",
                "Byl(a) jsem unesen(a) armádou krabů a musel(a) se naučit jejich jazyk.",
                "Ztratil(a) jsem klíče, protože mi je ukradla mašina na kávu.",
                "Můj pes začal zpívat a já jsem musel(a) napsat nový hit.",
                "Ztratil(a) jsem čas, protože jsem se rozhodl(a) meditovat na území snů.",
                "Moje auto se rozhodlo udělat si dovolenou na dovolené.",
                "Ztratil(a) jsem se ve snu a nemohl(a) najít cestu zpět.",
                "Ztratil(a) jsem hodinky, protože jsem je půjčil(a) stínu.",
                "Můj pes se rozhodl být kocourem a teď se chová velmi podivně.",
                "Ztratil(a) jsem se v supermarketu, kde se všechny regály proměnily v sochy.",
                "Moje kočka mi ukradla všechny plány na budoucnost.",
                "Moje žárovky se rozhodly psát vlastní historii.",
                "Můj stůl začal psát prohlášení o lidském právu na spánek.",
                "Můj pes byl zasažen meteoritem a teď je superhrdinou.",
                "Ztratil(a) jsem klíče, protože je sežrala moje kočka.",
                "Můj pes začal pořádání tanečního večírku v obýváku.",
                "Ztratil(a) jsem klíče, protože jsem je přenesl(a) do jiného časového pásma.",
                "Moje kočka mě přeměnila v duchy a už mě nechce zpátky.",
                "Můj pes byl zasažen elektrickým výbojem a teď je lepší než já.",
                "Ztratil(a) jsem směr, protože jsem se rozhodl(a) následovat mračna.",
                "Ztratil(a) jsem klíče, protože mě přepadl časový paradox.",
                "Můj stůl mě unesl a přivedl mě do kouzelné říše.",
                "Ztratil(a) jsem smysl pro směr, protože jsem ho zapomněl(a) doma.",
                "Moje auto se rozhodlo prozkoumat vesmír a já jsem na něj zapomněl(a).",
                "Ztratil(a) jsem klíče, protože jsem je nechal(a) v minulosti.",
                "Moje kočka mi začala psát dopisy a já jsem na ně odpovídal(a).",
                "Můj pes si vytvořil vlastní seznam úkolů, které jsem musel(a) splnit.",
                "Můj stůl mě zapomněl a já jsem se musel(a) rozhodnout, co s tím dělat.",
                "Ztratil(a) jsem smysl pro čas, protože jsem si začal(a) užívat svou vlastní ztrátu.",
                "Můj pes se stal masovým producentem a začal vyrábět sušenky.",
                "Ztratil(a) jsem se na cestě do školy, protože jsem se zastavil(a) na čajovou párty.",
                "Ztratil(a) jsem klíče, protože je sežral pes, který se mi snažil ukázat, jak to udělat.",
        };

        Set<String> usedExcuses = loadUsedExcuses();

        int absenceCount = loadAbsenceCount();
        absenceCount++;
        saveAbsenceCount(absenceCount);

        List<String> availableExcuses = new ArrayList<>();
        for (String excuse : excuses) {
            if (!usedExcuses.contains(excuse)) {
                availableExcuses.add(excuse);
            }
        }

        if (availableExcuses.isEmpty()) {
            System.out.println("Všechny výmluvy byly již použity.");
            return;
        }

        Random rand = new Random();
        String chosenExcuse = availableExcuses.get(rand.nextInt(availableExcuses.size()));
        System.out.println("Vaše výmluva: " + chosenExcuse);


        usedExcuses.add(chosenExcuse);

        saveUsedExcuses(usedExcuses);
    }

    private static Set<String> loadUsedExcuses() {
        Set<String> usedExcuses = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("used_excuses.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                usedExcuses.add(line);
            }
        } catch (IOException e) {

        }
        return usedExcuses;
    }

    private static void saveUsedExcuses(Set<String> usedExcuses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("used_excuses.txt"))) {
            for (String excuse : usedExcuses) {
                writer.write(excuse);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Chyba při ukládání výmluv: " + e.getMessage());
        }
    }

    private static int loadAbsenceCount() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            return Integer.parseInt(reader.readLine().trim());
        } catch (IOException | NumberFormatException e) {
            return 0;
        }
    }

    private static void saveAbsenceCount(int count) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(String.valueOf(count));
        } catch (IOException e) {
            System.out.println("Chyba při ukládání počtu absencí.");
        }
    }
}
