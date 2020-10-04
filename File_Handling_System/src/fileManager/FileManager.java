package fileManager;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileManager {
	public static void main(String[] args) {

		int option = 0;
		while (option != 3) {
			System.out.println("WELCOME TO FILE MANAGER" + "Developed by GIRISH ");
			try {
				Scanner s = new Scanner(System.in);
				//s.close();
				System.out.println("1) Show files");
				System.out.println("2) File Manager");
				System.out.println("3) EXIT");
				option = s.nextInt();
				//s.close();
				switch (option) {
				case 1: {
					int i = 1;
					File dir = new File("//home/girishshastri7g/Files/");
					String[] files = dir.list();
					if (files.length > 0) {
						Arrays.sort(files);
						System.out.println("Files present in the folder");
						for (String file : files) {
							System.out.println(i++ + " " + file);

						}

					} else {
						System.out.println("No files present in the folder");
					}
					break;

				}
				case 2: {
					int subOption = -1;
					while (subOption != 4) {
						Scanner s1 = new Scanner(System.in);
						//s1.close();
						try {
							System.out.println("2.1) Add files");
							System.out.println("2.2) Delete files");
							System.out.println("2.3) Search files");
							System.out.println("2.4) EXIT TO MAIN MENU");
							System.out.println("\nPlease select the option 1-4 to Add/Delete/Search/Exit");
							subOption = s1.nextInt();
							//s1.close();
							switch (subOption) {
							case 1: {
								System.out.println("Please enter file name to add");
								String fileName = s1.next();
								try {
									int result = createFile(fileName);
									if (result == 1) {
										System.out.println("New file created successfully");
									} else {
										System.out.println("File already exists");
									}
								} catch (IOException e) {
									System.out.println("Exception occurred while creating a file.\n" + e);
								}
								break;
							}
							case 2: {
								System.out.println("Please enter the file name to Delete");
								String fileName = s1.next();
								if (deleteFile(fileName)) {
									System.out.println("File deleted successfully");
								} else {
									System.out.println("Failed to Delete the file");
								}
								break;
							}
							case 3: {
								System.out.println("Please enter a file name to search");
								String fileName = s1.next();
								File dir = new File("//home/girishshastri7g/Files/");
								String[] files = dir.list();
								int searchedIndex = Arrays.binarySearch(files, fileName);
								if (searchedIndex >= 0) {
									System.out.println("Filehas been found at Index " + searchedIndex);
								} else {
									System.out.println("File Not Found");
								}
								break;
							}
							case 4:
								break;

							default:
								System.out.println("Enter Valid Option");

							}

						} catch (Exception e) {
							System.out.println("Enter Valid Input");
						}
					}
					break;

				}
				case 3:
					System.out.println("Thanks for using File Manager Application");
					System.exit(0);
					break;

				default:
					System.out.println("Enter Valid Option ");

				}
			} catch (InputMismatchException e) {
				System.out.println("Enter Valid Input");
			}
		}

	}

	private static boolean deleteFile(String fileName) {
		File file = new File("//home/girishshastri7g/Files/ " + fileName);
		return file.delete();
	}

	private static int createFile(String fileName) throws IOException {
		File file = new File("//home/girishshastri7g/Files/ " + fileName);
		if (file.exists()) {
			return -1;
		} else {
			file.createNewFile();
			return 1;
		}
	}

}
