def is_palindrome(s):
    """Silly but simple way to check palindrome-ness."""
    if len(s) % 2 == 0:
        return s[:len(s)//2] == s[:len(s)//2 - 1:-1]
    else:
        return s[:len(s)//2] == s[:len(s)//2:-1]

def even_search(s):
    """Find all even length palindromes in a string."""
    results = set()
    for i in range(1, len(s)-2):
        max_search = min(i, len(s) - 2 - i)
        best_palindrome = None
        for l in range(max_search):
            substring = s[i - l - 1: i + l + 3]
            if is_palindrome(substring):
                best_palindrome = substring
            else:
                break
        if best_palindrome:
            results.add(best_palindrome)
    return results

def odd_search(s):
    """Find all odd length palindromes in a string."""
    results = set()
    for i in range(1, len(s)-1):
        max_search = min(i, len(s) - 1 - i)
        best_palindrome = None
        for l in range(max_search):
            substring = s[i - l - 1: i + l + 2]
            if is_palindrome(substring):
                best_palindrome = substring
            else:
                break
        if best_palindrome:
            results.add(best_palindrome)
    return results

def is_sub_palindrome(test, palindrome):
    if len(test) < len(palindrome) and\
       len(test) % 2 == len(palindrome) % 2:
        offset = (len(palindrome) - len(test)) // 2
        if palindrome[offset:offset + len(test)]:
            return True
    return False

def is_sub_palindrome_pool(test, pool):
    for p in pool:
        if is_sub_palindrome(test, p):
            return True
    return False

def parse(s):
    """Find even and odd palindromes, then filter them, then join them."""
    e = even_search(s)
    o = odd_search(s)
    results = list(e | o)
    print(' '.join(sorted([_ for _ in results\
                           if not is_sub_palindrome_pool(_, results)])))

if __name__ == "__main__":
    parse("hello world.")
    parse("abbabbabba")
    parse("abcabc")
    parse("cabac")
