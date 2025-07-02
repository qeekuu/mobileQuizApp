package com.example.mobilequizapp.data

/*
object SampleQuestions {
	// Pytania z systemów
    val osSingle: List<Question> = listOf(
        Question(1, "Co to jest jądro systemu operacyjnego?", listOf("Kernel", "Shell", "GUI", "BIOS"), correctAnswerIndex = 0),
        // ... więcej pytań SO single ...
    )
    val osMulti: List<Question> = listOf(
        Question(1, "Które z poniższych to procesy jądra?", listOf("Scheduler", "File system", "Shell", "Memory manager"), correctAnswerIndices = listOf(0,1,3)),
        // ... więcej pytań SO multi ...
    )

	// Pytania z baz
    val dbSingle: List<Question> = listOf(
        Question(1, "Co oznacza SQL?", listOf("Structured Query Language", "Simple Query Language", "Sequential Query List", "Standard Query List"), correctAnswerIndex = 0),
        // ... więcej pytań BD single ...
    )
    val dbMulti: List<Question> = listOf(
        Question(1, "Które typy JOIN zwracają tylko wspólne wiersze?", listOf("INNER", "OUTER", "LEFT", "RIGHT"), correctAnswerIndices = listOf(0)),
        // ... więcej pytań BD multi ...
    )
}
*/

object SampleQuestions {
    // Pytania z systemów

    val osMulti: List<Question> = listOf(
        Question(
            1,
            "Określ, które informacje odnośnie zarządzania procesami w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "deskryptor procesu jest umieszczony na dnie jego stosu w jądrze systemu.",
                "makrodefinicja \"current\" zwraca adres deskryptora bieżącego procesu.",
                "proces w stanie TASK_UNINTERRUPTIBLE może być ustawiony w stanie gotowości przez dowolny sygnał, który otrzyma.",
                "proces zakończony ma stan TASK_STOPPED.",
                "proces, który jest wykonywany ma stan TASK_RUNNING."
            ),
            correctAnswerIndices = listOf(1, 4)
        ),
        Question(
            2,
            "Określ, które informacje odnośnie zarządzania procesami w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "proces, który jest gotów do wykonania znajduje się w stanie TASK_RUNNING.",
                "wątki w Linuksie są tworzone za pomocą innego wywołania systemowego niż procesy.",
                "proces \"init\" może zostać nowym rodzicem procesu, którego proces macierzysty już się zakończył.",
                "w trakcie tworzenia nowy proces otrzymuje osobny obszar tekstu i danych.",
                "deskryptory procesów są powiązane w dwukierunkową listę nazywaną listą procesów."
            ),
            correctAnswerIndices = listOf(0, 2, 4)
        ),
        Question(
            3,
            "Określ, które informacje o planiście O(1) są prawdziwe:",
            listOf(
                "nowy kwant czasu dla procesu jest ustalany dopiero wtedy, gdy wszystkie procesy w systemie wyczerpią swoje kwanty.",
                "kolejka procesów gotowych zawiera wskaźniki na dwie tablice priorytetów.",
                "każdy procesor ma swoją kolejkę procesów gotowych.",
                "priorytet zwykłych procesów jest ustalany wyłącznie na podstawie stopnia ich interaktywności.",
                "im wyższy jest priorytet procesu, tym krótszy kwant czasu on otrzymuje."
            ),
            correctAnswerIndices = listOf(1, 2)
        ),
        Question(
            4,
            "Określ, które informacje o planiście O(1) są prawdziwe:",
            listOf(
                "każdy nowo utworzony proces otrzymuje taki sam kwant czasu, jaki ma jego rodzic.",
                "zadanie o dużym stopniu interaktywności może, po wyczerpaniu swojego kwantu czasu, ponownie trafić do tablicy procesów aktywnych.",
                "proces użytkownika może być wywłaszczony w ramach powrotu z wywołania systemowego lub procedury obsługi przerwania.",
                "implementacja funkcji przełączającej kontekst (\"context_switch()\") zależy od architektury platformy sprzętowej, na której działa Linux.",
                "równoważenie obciążenia procesorów następuje wyłącznie wtedy, gdy kolejka procesów gotowych któregoś z nich jest pusta."
            ),
            correctAnswerIndices = listOf(1, 2, 3)
        ),
        Question(
            5,
            "Określ, które informacje o planiście CFS są prawdziwe:",
            listOf(
                "priorytety procesów są prawie niezmienne.",
                "klasa szeregowania SCHED_BATCH jest obsługiwana za pomocą algorytmu rotacyjnego.",
                "waga procesu jest odwrotnością wartości jego priorytetu.",
                "zegar wirtualny jest wprost implementowany w jądrze Linuksa.",
                "kolejka procesów gotowych jest zrealizowana w postaci drzewa czerwono-czarnego."
            ),
            correctAnswerIndices = listOf(0, 4)
        ),
        Question(
            6,
            "Określ, które informacje o planiście CFS są prawdziwe:",
            listOf(
                "czas fizyczny jest mierzony z dokładnością nanosekundową.",
                "dla procesów z priorytetem równym 0 czas wirtualny jest taki sam jak czas fizyczny.",
                "czas wybierania procesów przez planistę CFS jest zawsze krótszy w porównaniu z analogicznym czasem dla planisty O(1).",
                "czas wirtualny procesu zależy od jego wagi.",
                "planista przydziela procesor temu procesowi, który najdłużej z niego korzystał."
            ),
            correctAnswerIndices = listOf(0, 1, 3)
        ),
        Question(
            7,
            "Określ, które informacje dotyczące wywołań systemowych w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "wszystkie funkcje z biblioteki \"libc\" korzystają z wywołań systemowych.",
                "wywołania systemowe mogą nie przyjmować żadnych argumentów.",
                "każde wywołanie systemowe zwraca wartość stanowiącą kod jego wykonania.",
                "zazwyczaj wywołania systemowe implementowane są w postaci funkcji napisanych w assemblerze.",
                "dodanie do jądra nowego wywołania systemowego wymaga modyfikacji biblioteki \"libc\", aby umożliwić procesom użytkownika korzystanie z niego."
            ),
            correctAnswerIndices = listOf(1, 2)
        ),
        Question(
            8,
            "Określ, które informacje dotyczące wywołań systemowych w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "adresy wszystkich zarejestrowanych wywołań systemowych są przechowywane w specjalnej tablicy.",
                "kod funkcji implementującej wywołanie systemowe może być umieszczony w module.",
                "dodawanie nowych wywołań systemowych jest zalecaną przez programistów jądra Linuksa praktyką.",
                "część procesorów wymaga, aby argumenty do funkcji implementujących wywołania systemowych były przekazywane wyłącznie przez stos.",
                "funkcja implementująca wywołanie systemowe musi sprawdzać poprawność przekazanych jej argumentów."
            ),
            correctAnswerIndices = listOf(0, 3, 4)
        ),
        Question(
            9,
            "Określ, które informacje dotyczące obsługi przerwań w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "procedury obsługi przerwań w Linuksie są funkcjami napisanymi w języku C.",
                "procedury obsługi przerwań są wykonywane w kontekście przerwania.",
                "procedury obsługi przerwań są wywoływane w sposób asynchroniczny.",
                "linie zgłaszania przerwań (IRQ) mogą być współdzielone.",
                "niektóre przerwania mogą zasilać pulę entropii jądra."
            ),
            correctAnswerIndices = listOf(0, 1, 2, 3, 4)
        ),
        Question(
            10,
            "Określ, które informacje dotyczące obsługi przerwań w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "większość procedur obsługi przerwań korzysta z makrodefinicji \"current\".",
                "stos z którego korzystają procedury obsługi przerwań ma nieograniczoną wielkość.",
                "wszystkie procedury obsługi przerwań wymagają wyłączenia wszystkich linii zgłaszania przerwań na czas ich wykonywania.",
                "w komputerach klasy PC wszystkie numery przerwań są przydzielane statycznie.",
                "czas wykonania procedur obsługi przerwań (górnych połówek) może być dowolnie długi."
            ),
            correctAnswerIndices = listOf()
        ),
        Question(
            11,
            "Określ, które informacje dotyczące dolnych połówek w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "całkowita liczba przerwań programowych jest ograniczona.",
                "przerwania programowe są wykonywane w kontekście procesu.",
                "tasklety są wykonywane w kontekście procesu.",
                "czynności z kolejek prac są wykonywane w kontekście przerwania.",
                "można precyzyjnie określić czas, po którym przerwanie programowe powinno być wykonane."
            ),
            correctAnswerIndices = listOf(0)
        ),
        Question(
            12,
            "Określ, które informacje dotyczące dolnych połówek w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "przerwania programowe są alokowane statycznie podczas kompilacji jądra.",
                "można określić minimalny czas, o jaki zostanie opóźnione wykonanie czynności w kolejkach prac.",
                "te same tasklety mogą być wykonywane współbieżnie na platformach wieloprocesorowych.",
                "wątek \"ksoftirqd\" odpowiedzialny jest zarówno za obsługę przerwań programowych, jak i kolejek prac.",
                "istnieje możliwość stworzenia kolejki prac, która będzie obsługiwana na platformach wieloprocesorowych przez pojedynczy wątek roboczy."
            ),
            correctAnswerIndices = listOf(0, 1, 4)
        ),
        Question(
            13,
            "Określ, które informacje dotyczące środków synchronizacji w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "funkcje realizujące operacje niepodzielne na liczbach całkowitych działają na zmiennych typu \"int\".",
                "niepodzielne operacje na bitach przeprowadzane są za pomocą tych samych funkcji co niepodzielne operacje na liczbach całkowitych.",
                "rygle pętlowe wprowadzają wątki oczekujące na ich zwolnienie w stan aktywnego oczekiwania.",
                "zwykły rygiel pętlowy może być przetrzymywany przez kilka wątków jednocześnie.",
                "rygle pętlowe nie są używane w systemach jednoprocesorowych."
            ),
            correctAnswerIndices = listOf(2, 4)
        ),
        Question(
            14,
            "Określ, które informacje dotyczące środków synchronizacji w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "rygiel pętlowy czytelnika może być jednocześnie przetrzymywany przez więcej niż jeden wątek wykonania.",
                "semafory mogą być stosowane w procedurach obsługi przerwań.",
                "semafor nie może być przetrzymywany przez wątek, który już przetrzymuje rygiel pętlowy.",
                "stosowanie blokady BKL nie jest zalecane.",
                "mechanizm RCU niszczy oryginalną informację w momencie, kiedy wątek-pisarz opublikuje wskaźnik na jej zmodyfikowaną kopię."
            ),
            correctAnswerIndices = listOf(0, 2, 3)
        ),
        Question(
            15,
            "Określ, które informacje dotyczące pomiaru i synchronizacji względem czasu w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "zegar czasu rzeczywistego (RTC) jest okresowo odczytywany przez jądro systemu.",
                "liczbę taktów zegara od uruchomienia systemu przechowuje zmienna \"jiffies\".",
                "częstotliwość zegara systemowego jest określona stałą \"HZ\".",
                "implementacja procedury obsługi przerwania zegarowego jest całkowicie niezależna od sprzętu.",
                "wartość stałej \"HZ\" jest taka sama dla wszystkich platform sprzętowych."
            ),
            correctAnswerIndices = listOf(1, 2)
        ),
        Question(
            16,
            "Określ, które informacje dotyczące pomiaru i synchronizacji względem czasu w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "liczniki niskiej rozdzielczości są cykliczne.",
                "mechanizm liczników wysokiej rozdzielczości korzysta z drzewa czerwono-czarnego.",
                "liczniki wysokiej rozdzielczości mogą być cykliczne.",
                "funkcje związane z licznikami niskiej rozdzielczości wykonywane są w kontekście przerwania.",
                "jeśli platforma sprzętowa nie dostarcza zegarów o nanosekundowej precyzji, to mechanizm liczników wysokiej rozdzielczości nie jest dla niej w ogóle dostępny."
            ),
            correctAnswerIndices = listOf(1, 2, 3)
        ),
        Question(
            17,
            "Określ, które informacje dotyczące zarządzania pamięcią w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "Linux obsługuje systemy wieloprocesorowe o organizacji NUMA.",
                "domyślnie Linux przydziela pamięć ze strefy DMA (ZONE_DMA).",
                "podstawowym mechanizmem sprzętowym wykorzystywanym przez Linuksa do obsługi pamięci jest segmentacja.",
                "nie we wszystkich platformach sprzętowych musi występować strefa pamięci wysokiej (ZONE_HIGHMEM).",
                "niskopoziomowy mechanizm obsługi pamięci umożliwia przydzielenie obszaru pamięci o wielkości jednego bajta."
            ),
            correctAnswerIndices = listOf(0, 3)
        ),
        Question(
            18,
            "Określ, które informacje dotyczące zarządzania pamięcią w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "niskopoziomowy mechanizm obsługi pamięci działa w oparciu o algorytm bliźniaków.",
                "adresowanie stron w Linuksie jest domyślnie czteropoziomowe.",
                "alokator plastrowy wykorzystuje do własnych celów dedykowane pamięci podręczne.",
                "alokator plastrowy jest rozwiązaniem zapożyczonym z systemu operacyjnego firmy Sun Microsystems.",
                "alokator plastrowy przydziela pamięć na struktury często alokowane i zwalniane przez jądro systemu."
            ),
            correctAnswerIndices = listOf(0, 1, 3, 4)
        ),
        Question(
            19,
            "Określ, które informacje dotyczące wirtualnego systemu plików (VFS) w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "VFS napisany jest w języku C++.",
                "obiekt superbloku może być stosowany w obsłudze systemów plików, które nie mają fizycznej implementacji.",
                "obiekty i-węzłów związane są wyłącznie z fizycznymi plikami.",
                "niektóre nieuniksowe systemy plików nie posiadają wszystkich informacji, które muszą być umieszczone w obiekcie i-węzła.",
                "obiekty wpisów katalogowych mają swoje odpowiedniki na nośniku danych."
            ),
            correctAnswerIndices = listOf(1, 3)
        ),
        Question(
            20,
            "Określ, które informacje dotyczące wirtualnego systemu plików (VFS) w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "obiekt wpisu katalogowego, który nie jest w użyciu, ale któremu odpowiada prawidłowy i-węzeł, jest w stanie ujemnym.",
                "obiekty wpisu katalogowego, które są w stanie ujemnym, nie są niszczone, jeśli nie zachodzi taka potrzeba.",
                "obiekty plików związane są ze wszystkimi plikami zapisanymi w systemie plików.",
                "pamięć na obiekty wpisów katalogowych jest przydzielana i zwalniana przez alokator plastrowy.",
                "dla każdego zamontowanego systemu plików tworzona jest zmienna opisująca jego punkt montowania."
            ),
            correctAnswerIndices = listOf(1, 3, 4)
        ),
        Question(
            21,
            "Określ, które informacje dotyczące obsługi urządzeń znakowych i blokowych w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "urządzenia obsługiwane przez Linuksa są wyłącznie urządzeniami fizycznymi.",
                "w komputerach klasy PC kontroler jest zawsze częścią struktury sprzętowej łączącej szynę wejścia-wyjścia z urządzeniem.",
                "rejestr może pełnić więcej niż jedną funkcję.",
                "numer główny identyfikuje sterownik obsługujący urządzenie lub grupę urządzeń.",
                "urządzenia znakowe adresują dane sekwencyjnie."
            ),
            correctAnswerIndices = listOf(2, 3, 4)
        ),
        Question(
            22,
            "Określ, które informacje dotyczące obsługi urządzeń znakowych i blokowych w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "sterownik urządzenia może być dołączony do systemu w postaci modułu.",
                "sterowniki urządzeń znakowych korzystają z niektórych struktur związanych z wirtualnym systemem plików (VFS).",
                "programista piszący sterownik urządzenia znakowego musi oprogramować metody obiektu i-węzła.",
                "metody obsługujące urządzenia znakowe muszą działać według określonego protokołu.",
                "sterowniki wszystkich urządzeń blokowych muszą tworzyć kolejki żądań."
            ),
            correctAnswerIndices = listOf(0, 1, 3)
        ),
        Question(
            23,
            "Określ, które informacje dotyczące warstwy operacji blokowych w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "wielkość bloku w Linuksie jest nieograniczona.",
                "każdy bufor zawsze jest związany z blokiem na nośniku danych.",
                "bufory są wykorzystywane wyłącznie do przechowywania danych odczytanych z nośnika urządzenia blokowego.",
                "każdy z buforów wyposażony jest w nagłówek zawierający dane niezbędne do zarządzania nim.",
                "nagłówek bufora nie przechowuje informacji o operacjach wejścia-wyjścia z jakimi ten bufor jest związany."
            ),
            correctAnswerIndices = listOf(1, 3, 4)
        ),
        Question(
            24,
            "Określ, które informacje dotyczące warstwy operacji blokowych w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "struktury \"bio\" reprezentują operacje wejścia-wyjścia podczas ich trwania.",
                "wielkość segmentu jest zawsze równa wielkości bufora.",
                "struktury \"bio\" ułatwiają realizację operacji wejścia-wyjścia o rozproszonym źródle.",
                "planista terminowy przydziela domyślnie dłuższy termin realizacji operacji odczytu niż operacji zapisu.",
                "planista CFQ nie stosuje przewidywania."
            ),
            correctAnswerIndices = listOf(0, 2)
        ),
        Question(
            25,
            "Określ, które informacje dotyczące obsługi przestrzeni adresowej procesu w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "wszystkie wątki jądra korzystają z jednego, wspólnego dla nich deskryptora pamięci.",
                "obiekty zawierające informacje o obszarach pamięci są umieszczone jednocześnie w dwóch różnych strukturach danych.",
                "sekcje tekstu tworzone są nie tylko dla procesów, ale również dla bibliotek współdzielonych.",
                "deskryptor pamięci przechowuje adres startowy i końcowy obszaru argumentów wywołania programu.",
                "deskryptory pamięci nigdy nie są współdzielone przez procesy (wątki) użytkownika."
            ),
            correctAnswerIndices = listOf(1, 2, 3)
        ),
        Question(
            26,
            "Określ, które informacje dotyczące obsługi sieci w Linuksie 3.0 i nowszych są prawdziwe:",
            listOf(
                "jądro wykonuje czynności związane z obsługą warstwy łącza, sieci i transportowej modelu ISO/OSI",
                "NAPI nigdy nie pozwala na sygnalizowanie odbioru pakietu za pomocą przerwania",
                "przenoszenie bufora pakietu między kolejkami jest czasochłonne",
                "funkcje związane z filtrem sieciowym mogą \"wykradać\" niektóre pakiety, aby przetworzyć je w inny sposób niż pozostałe",
                "w filtrze sieciowym, z pojedynczym uchwytem nie może być skojarzona więcej niż jedna funkcja przetwarzająca"
            ),
            correctAnswerIndices = listOf(0, 1, 3)
        ),
        // 27
        Question(
            27,
            "Które z poniższych zdań dotyczących algorytmu szeregowania O(1) są prawdziwe?",
            listOf(
                "Wymiana priorytetów zadań sprowadza się do zamiany wskaźników na tablice aktywną i przeterminowaną",
                "Priorytet każdego zadania jest ustalany wyłącznie na podstawie jego interaktywności",
                "Promowane są zadania o wysokim stopniu interaktywności",
                "Mechanizm szeregowania dokonuje zrównoważenia obciążenia procesorów wyłącznie wtedy, kiedy kolejka zadań jednego z nich jest pusta",
                "Kwanty czasu dla poszczególnych zadań są przeliczane dopiero wówczas, gdy ostatnie z zadań znajdujących się w tablicy priorytetów aktywnych wyczerpie swój kwant czasu"
            ),
            correctAnswerIndices = listOf(0, 2)
        ),
        // 28
        Question(
            28,
            "Które z twierdzeń dotyczących obsługi przerwań w Linuksie 2.6 są prawdziwe?",
            listOf(
                "Obsługa przerwań podzielona jest na górną połówkę i dolną połówkę",
                "Procedury obsługi przerwań mogą być wykonywane dowolnie długo",
                "Do linii obsługi przerwania o określonym numerze może być przypisanych kilka procedur obsługi przerwań",
                "W procedurach obsługi przerwań można wywołać funkcje, które ulegają blokowaniu",
                "Procedury obsługi przerwań korzystają ze stosu jądra, który ma nieograniczony rozmiar"
            ),
            correctAnswerIndices = listOf(0, 2)
        ),
        // 29
        Question(
            29,
            "Określ, które ze zdań dotyczących szeregowania procesów w Linuxie 2.6 są prawdziwe?",
            listOf(
                "Linux realizuje wielozadaniowość w oparciu o kooperację",
                "Działanie planisty O(1) oparte jest na schemacie kolejek ze sprzężeniem zwrotnym",
                "Zadania interaktywne otrzymują od planisty O(1) mniejszy kwant czasu niż zadania nieinteraktywne",
                "Główną struktura planisty CFS jest drzewo czerwono-czarne",
                "Linux nie jest rygorystycznym systemem czasu rzeczywistego"
            ),
            correctAnswerIndices = listOf(1, 3, 4)
        ),
        // 30
        Question(
            30,
            "Które ze zdań dotyczących kolejek prac są prawdziwe?",
            listOf(
                "Czynności odroczone wykonywane w ramach kolejek prac wykonywane są w kontekście przerwania",
                "Kolejki prac zastąpiły mechanizm dolnych połówek znany jako kolejki zadań",
                "Mechanizm kolejek prac pozwala na określenie czasu po upływie, którego dana czynność może się rozpocząć",
                "Jądro systemu Linux zawiera specjalną funkcję, która pozwala na opróżnienie domyślnej kolejki prac",
                "Jeśli w jądrze tworzona jest nowa kolejka prac, to jest równocześnie dla niej tworzony nowy, odrębny wątek roboczy"
            ),
            correctAnswerIndices = listOf(1, 2, 3, 4)
        ),
        // 31
        Question(
            31,
            "Pytania INNE:",
            listOf(
                "Algorytm noop realizuje tylko operacje scalania",
                "Alokator plastrowy przechowuje własne struktury w pamięci dedykowanej",
                "Alokator plastrowy przydziela pamięć na deskryptor",
                "Alokator plastrowy przydziela w pierwszej kolejności pamięć z plastrów pustych",
                "Argumenty wywołań systemowych są przekazywane tylko przez rejestry programowe"
            ),
            correctAnswerIndices = listOf(0, 2)
        ),
        // 32
        Question(
            32,
            "Pytania INNE:",
            listOf(
                "Deskryptor procesu jest opisywany strukturą struct thread_info",
                "Deskryptory pamięci są połączone w listę i drzewo czerwono-czarne",
                "Jądro cyklicznie odczytuje wartości z zegara czasu rzeczywistego (RTC)",
                "Jądro może przydzielić dodatkową przestrzeń adresową dla procesu podczas jego wykonywania",
                "Każda ramka jest określona strukturą struct page"
            ),
            correctAnswerIndices = listOf(1, 3, 4)
        ),
        // 33
        Question(
            33,
            "Pytania INNE:",
            listOf(
                "Każde urządzenie musi mieć inny numer przerwania",
                "Kod w mechanizmie RCU może ulec zawieszeniu",
                "Licznik monotoniczny jest wysokiej rozdzielczości",
                "Liczniki bazują na taskletach",
                "Liczniki dynamiczne ze względu na zbyt małą precyzję nie mogą być wykorzystywane w zadaniach czasu rzeczywistego"
            ),
            correctAnswerIndices = listOf(0, 2)
        ),
        // 34
        Question(
            34,
            "Pytania INNE:",
            listOf(
                "Liczniki wysokiej rozdzielczości pozwalają na ich regulowanie z nanosekundową precyzją",
                "Listy liczników nie są przez system sortowane",
                "Maksymalna ilość przerwań programowych wynosi 32",
                "Mechanizm RCU posługuje się wskaźnikami",
                "Niektóre pola struktury dotyczącej plików mogą być wypełniane dowolnymi wartościami"
            ),
            correctAnswerIndices = listOf(0, 1, 2, 3, 4)
        ),
        // 35
        Question(
            35,
            "Pytania INNE:",
            listOf(
                "Obsługa struktury bio jest mniej skomplikowana niż obsługa nagłówków buforów",
                "Odczyty w mechanizmie RCU powinny być częste, a zapisy sporadyczne",
                "Pamięć fizyczna nieciągła jest przydzielana za pomocą algorytmu bliźniaków",
                "PID może być ujemny",
                "Planista CFS całkowicie zastąpił planistę O(1)"
            ),
            correctAnswerIndices = listOf(0, 1, 4)
        ),
        // 36
        Question(
            36,
            "Pytania INNE:",
            listOf(
                "Planista CFS korzysta z tablicy odwrotności priorytetów",
                "Planista CFS przelicza priorytety procesów na wagi",
                "Plik jest powiązany z wpisem katalogowym",
                "Procesy które nie korzystają z procesora są przesuwane w lewą stronę drzewa czerwono-czarnego",
                "Procesy mogą współdzielić deskryptor pamięci"
            ),
            correctAnswerIndices = listOf(1, 3, 4)
        ),
        // 37
        Question(
            37,
            "Pytania INNE:",
            listOf(
                "Procesy UNINTERRUPTIBLE mogą zostać ustawione w stan gotowości przez inne zdarzenie niż to, na które oczekują",
                "Programista jądra powinien się posługiwać funkcją printf",
                "Programista jądra powinien używać funkcji rekurencyjnych",
                "Programista może napisać dedykowaną pamięć podręczną dla alokatora plastrowego",
                "Programista powinien zwracać uwagę na rozmiar stosu jądra"
            ),
            correctAnswerIndices = listOf(3, 4)
        ),
        // 38
        Question(
            38,
            "Pytania INNE:",
            listOf(
                "Przerwania programowe są wykorzystywane przy taskletach",
                "Przerwanie składa się z dwóch połówek",
                "Przy wywołaniach systemowych jest używany sys_",
                "Rozmiar sektora dla urządzeń blokowych wynosi zazwyczaj 1024 bajty",
                "Rygle pętlowe powinny być stosowane wszędzie tam, gdzie nie można zawiesić wątku i gdzie czas przełączania kontekstu byłby niewspółmiernie dłuższy z czasem aktywnego oczekiwania"
            ),
            correctAnswerIndices = listOf(1, 2, 4)
        ),
        // 39
        Question(
            39,
            "Pytania INNE:",
            listOf(
                "Rygle pętlowe są użyteczne w systemach jednoprocesorowych z wywłaszczaniem jądra",
                "Stan procesów po zakończeniu jest przechowywany w tym samym polu deskryptora",
                "Stronicowanie nigdy nie korzysta z segmentacji",
                "Struktura bio korzysta z listy offsetów",
                "Struktura bio może być wykorzystywana w macierzach RAID"
            ),
            correctAnswerIndices = listOf(4)
        ),
        // 40
        Question(
            40,
            "Pytania INNE:",
            listOf(
                "VFS jest zapożyczony od Microsoftu",
                "W 64-bitowych procesorach pamięć wysoka jest oznaczona jako HIGHMEM",
                "W wersji 2.6 deskryptor pamięci jest przechowywany na stosie",
                "Wirtualny system plików jest modelem obiektowym",
                "Wszystkie pliki na dysku są reprezentowane przez VFS"
            ),
            correctAnswerIndices = listOf(3)
        ),
        // 41
        Question(
            41,
            "Pytania INNE:",
            listOf(
                "Zawartość zegara czasu rzeczywistego jest odczytywana przez jądro co pewien okres czasu",
                "Zmienna jiffies jest nałożona na starsze 32 bity zmiennej jiffies_64",
                "Zmienna jiffies przechowuje informacje o czasie rzeczywistym systemu",
                "Zwiększenie wartości stałej HZ powoduje zmniejszenie częstotliwości przerwań zegarowych",
                "Rygle pętlowe są rekurencyjne"
            ),
            correctAnswerIndices = listOf()
        ),
        // 42
        Question(
            42,
            "Poniżej umieszczono zdania dotyczące obsługi przerwań przez Linuksa 2.6. Które z nich są prawdziwe?",
            listOf(
                "Częstotliwości pojawiania się wszystkich przerwań są wykorzystywane do inicjalizowania generatora liczb losowych",
                "Numery przerwań mogą być przydzielane niektórym urządzeniom dynamicznie",
                "Aby procedura obsługi przerwania mogła być wywołana, musi zostać wcześniej zarejestrowana",
                "Procedury obsługi przerwań mogą korzystać z wartości zwracanej przez makrodefinicję current",
                "Nie jest wymagane, aby funkcje obsługi przerwań były wielobieżne"
            ),
            correctAnswerIndices = listOf(1, 2, 4)
        ),
        // 43
        Question(
            43,
            "Które ze zdań dotyczących synchronizacji są prawdziwe?",
            listOf(
                "Niektóre operacje niepodzielne mogą być zrealizowane jako pojedyncze rozkazy procesora",
                "Przeplot operacji jest przyczyną występowania problemu sekcji krytycznej",
                "W systemie Linux, w przestrzeni użytkownika wywłaszczenie procesu może zajść tylko w ściśle określonym momencie jego działania",
                "Zadanie nigdy nie może być wywłaszczone po zakończeniu obsługi przerwania",
                "Dostęp do zmiennych lokalnych wątków wykonania nie musi podlegać synchronizacji"
            ),
            correctAnswerIndices = listOf(0, 1, 2, 4)
        ),
        // 44
        Question(
            44,
            "Które twierdzenie odnośnie wątków i procesów w systemie Linux są prawdziwe?",
            listOf(
                "Za szeregowanie wątków odpowiada inny mechanizm jądra niż za szeregowanie procesów",
                "Każdy wątek jądra posiada swoją odrębną przestrzeń adresową",
                "Makrodefinicja current pozwala na szybki dostęp do deskryptora bieżącego procesu",
                "Proces macierzysty, którego proces potomny się zakończył przechodzi w stan TASK_ZOMBIE",
                "Deskryptory procesów powiązane są w listę"
            ),
            correctAnswerIndices = listOf(2, 4)
        ),
        // 45
        Question(
            45,
            "Które stwierdzenia są prawidłowe?",
            listOf(
                "Zmienna typu atomic_t jest 32 bitowa",
                "Wszystkie architektury, które obsługuje Linux dostarczają rozkazów maszynowych realizujących operacje niepodzielne na wartościach będących liczbami całkowitymi",
                "Rygle pętlowe mogą być stosowane we fragmentach kodu wykonywujących się w kontekście przerwania",
                "Rygle R-W stosujemy w zagadnieniach typu problem czytelników i pisarzy, gdzie faworyzowani są pisarze",
                "Zmienne sygnałowe są uproszczoną wersją semaforów"
            ),
            correctAnswerIndices = listOf(0, 2, 4)
        ),
        // 46
        Question(
            46,
            "Które z poniższych stwierdzeń dotyczących środków synchronizacji w jądrze Linuksa 2.6 są prawdziwe?",
            listOf(
                "Wątek wykonania który przetrzymuje semafor nie może równocześnie przetrzymywać rygla pętlowego",
                "Blokady sekwencyjne pozwalają ustalić czy operacja odczytu nie została przepleciona z operacją zapisu",
                "Blokada BKL jest blokadą gruboziarnistą",
                "Blokada BKL nie jest rekurencyjna",
                "Rygle pętlowe nie są używane w systemach jednoprocesorowych w jądrze, które nie wywłaszcza wątków"
            ),
            correctAnswerIndices = listOf(0, 1, 2, 4)
        ),
        // 47
        Question(
            47,
            "Które ze stwierdzeń dotyczących wywołań systemowych w Linuksie 2.6 są prawdziwe?",
            listOf(
                "Dodawanie nowych wywołań systemowych nie jest zalecanym przez twórców jądra sposobem dodawania nowej funkcjonalności",
                "Każde wywołanie systemowe zwraca wartość typu long",
                "Każde wywołanie systemowe musi przyjmować co najmniej jeden argument wywołania",
                "Wszystkie funkcje ze standardowej biblioteki języka C korzystają z wywołań systemowych",
                "Funkcja realizująca wywołanie systemowe musi być w całości napisana w assemblerze"
            ),
            correctAnswerIndices = listOf(0, 1)
        ),
        // 48
        Question(
            48,
            "Które stwierdzenia są prawidłowe?",
            listOf(
                "Programista nie powinien używać funkcji goto",
                "Architektura NUMA jest obsługiwana od wersji jądra 2.6",
                "Stała HZ dla architektury i386 wynosi 1000",
                "Czy liczniki niskiej rozdzielczości działają z mikrosekundową precyzją?",
                "Użytkownik uprzywilejowany może dowolnie zmieniać wartość stałej HZ"
            ),
            correctAnswerIndices = listOf(0, 1, 2, 3)
        ),
        // 49
        Question(
            49,
            "Które stwierdzenia są prawidłowe?",
            listOf(
                "Makrodefinicja current pozwala na dostęp do deskryptora bieżącego procesu",
                "Deskryptor procesu znajduje się na końcu stosu jądra dla wywołań systemowych procesu",
                "VFS jest napisany w C++?",
                "Obiekt wpisu katalogowego (dentry) może posiadać wyłącznie dwa stany",
                "Urządzenie znakowe jest zwykłym plikiem"
            ),
            correctAnswerIndices = listOf(0)
        ),
        // 50
        Question(
            50,
            "Które stwierdzenia są prawidłowe?",
            listOf(
                "Struktura bio reprezentuje operacje wejścia-wyjścia w trakcie ich trwania",
                "Wątki jądra mają własną sekcję tekstu",
                "Deskryptory procesów są połączone w listę dwukierunkową",
                "Struktura thread_struct jest deskryptorem procesu",
                "Urządzenia znakowe mają dostęp sekwencyjny"
            ),
            correctAnswerIndices = listOf(0, 2, 4)
        )

    )

	val osSingle: List<Question> = listOf(
		// Question(…)…
	)

	val dbSingle: List<Question> = listOf(
		/* your single-select database questions */
	)

	val dbMulti: List<Question> = listOf(
		/* your multi-select database questions */
	)
}
