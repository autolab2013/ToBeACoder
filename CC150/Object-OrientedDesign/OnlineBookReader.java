/** 8.5 Design the data structure for an online book reader system.
 *  
 */
 
/** I think
 *  system contains books and users,
 *  user membership creation & extension
 *  search for book;
 *  read a book;
 *  only one active user at a time;
 *  only one active book by this user;
 *  
 *  singleton user.getInstance(); activeBook.getInstance();
 *  User{
 *  	id;
 *  	password;
 *  	Membership;
 *  	activeBook;
 *  
 *  	getInstance();
 *  	readBook();
 *  	returnBook();
 *  }
 *  
 *  UserManager{
 *  	users[];
 *  	
 *  	addUser();
 *  	deleteUser();
 *  	checkMembership();
 *  	findUser();
 *  }
 *  
 *  Book{
 *  	id;
 *  	detail;
 *  
 *  	getId();
 *  	setId();
 *  }
 *  
 *  BookManager{
 *  	books[];
 *  	
 *  	addBook();
 *  	deleteBook();
 *  	findBook();
 *  }
 *  System{
 *  	activeUser;
 *  	activeBook;
 *  	UserManager;
 *  	BookManager;
 *  
 *  	getActiveUser();
 *  	getActiveBook();
 *  	SetActiveBook();
 *  	SetActiveUser();
 *  }
 *  
 */
