-module(romans).
-export([romanize/1, test/0]).

% TODO: add a map for place value storage.

test() ->
    "I" = romanize(1),
    "X" = romanize(10),
    "XI" = romanize(11),
    "XII" = romanize(12),
    "XIII" = romanize(13),
    "XXIV" = romanize(24),
    "XXXV" = romanize(35),
    "XXXVI" = romanize(36),
    "XLVII" = romanize(47),
    "LVIII" = romanize(58),
    "LXXXIX" = romanize(89),
    "XC" = romanize(90),
    "XCIX" = romanize(99),
    ok.


push([Char|Tail], Text) ->
    push(Tail, [Char|Text]);
push([], Text) ->
    Text.

chooseRoman(N, [First|Tail]) ->
    if
        First =< N -> First;
        First > N -> chooseRoman(N, Tail)
    end.
    
romanize(0) ->
    "nulla";
romanize(1) ->
    "I";
romanize(4) ->
    "IV";
romanize(5) ->
    "V";
romanize(9) ->
    "IX";
romanize(10) ->
    "X";
romanize(40) ->
    "XL";
romanize(50) ->
    "L";
romanize(90) ->
    "XC";
romanize(100) ->
    "C";
romanize(N) when is_integer(N) andalso N < 300 ->
    romanize(N, "").

romanize(0, Accumulator) ->
    lists:reverse(Accumulator);
romanize(N, Accumulator) ->
    Current = chooseRoman(N, [100, 90, 50, 40, 10, 9, 5, 4, 1]),
    Numerals = romanize(Current),
    romanize(N-Current, push(Numerals, Accumulator)).

