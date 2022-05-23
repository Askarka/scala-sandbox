def `c d a`[T](someList: List[T], nDups: Int): List[T] = someList.flatMap(a => List.fill(nDups)(a))

print(`c d a`(List(1, 2 ,3), 4))

def `short name`(name: String) = name.take(2).toUpperCase + "."
val names = List("Alex", "Sam", "Peter", "andrew")


names map `short name` filter (_.startsWith("A"))
names map `short name` filter (_.startsWith("a"))

