
public class FuhrparkSetTest extends Assert {

	@Tst
	public void insert_shouldInsert() {
		FuhrparkSet s = new FuhrparkSet();
		Fuhrpark f = new Fuhrpark("f1");
		Fuhrpark f2 = new Fuhrpark("f2");
		assertEquals(null, s.get("f1"));
		assertTrue(s.insert(f));
		assertEquals(f, s.get("f1"));
		assertTrue(s.insert(f2));
		assertEquals(f2, s.get("f2"));
	}

	@Tst
	public void insert_shouldNotInsertIfAllreadyInSet() {
		FuhrparkSet s = new FuhrparkSet();
		Fuhrpark f = new Fuhrpark("f1");
		Fuhrpark f2 = new Fuhrpark("f1");
		s.insert(f);
		assertFalse(s.insert(f2));
		assertEquals(f, s.get("f1"));
	}
}
