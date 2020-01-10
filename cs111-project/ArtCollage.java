/*************************************************************************
 *  Compilation:  javac ArtCollage.java
 *  Execution:    java ArtCollage
 *
 *  @author:William Wang
 *
 *************************************************************************/

import java.awt.Color;

public class ArtCollage {

    // The orginal picture
    private Picture original;

    // The collage picture
    private Picture collage;

    // The collage Picture consists of collageDimension X collageDimension tiles
    private int collageDimension;

    // A tile consists of tileDimension X tileDimension pixels
    private int tileDimension;
    
    /*
     * One-argument Constructor
     * 1. set default values of collageDimension to 4 and tileDimension to 100
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename) {
    	
        // WRITE YOUR CODE HERE
        tileDimension = 100;
        collageDimension = 4;

        original = new Picture(filename);
    	collage = new Picture(tileDimension * collageDimension, tileDimension * collageDimension);
    	
    	for (int tcol = 0; tcol < tileDimension * collageDimension; tcol++)
        {
            for (int trow = 0; trow < tileDimension * collageDimension; trow++)
            {
                int scol = tcol * original.width() / (tileDimension * collageDimension);
                int srow = trow * original.height() / (tileDimension * collageDimension);
                Color color = original.get(scol, srow);
                collage.set(tcol, trow, color);
            }
        }
    }

    /*
     * Three-arguments Constructor
     * 1. set default values of collageDimension to cd and tileDimension to td
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename, int td, int cd) {

        // WRITE YOUR CODE HERE
    	tileDimension = td;
        collageDimension = cd;

        original = new Picture(filename);
    	collage = new Picture(tileDimension * collageDimension, tileDimension * collageDimension);
    	
    	for (int tcol = 0; tcol < tileDimension * collageDimension; tcol++)
        {
            for (int trow = 0; trow < tileDimension * collageDimension; trow++)
            {
                int scol = tcol * original.width() / (tileDimension * collageDimension);
                int srow = trow * original.height() / (tileDimension * collageDimension);
                Color color = original.get(scol, srow);
                collage.set(tcol, trow, color);
            }
        }
    }

    /*
     * Returns the collageDimension instance variable
     *
     * @return collageDimension
     */
    public int getCollageDimension() {

        // WRITE YOUR CODE HERE
    	return collageDimension;
    }

    /*
     * Returns the tileDimension instance variable
     *
     * @return tileDimension
     */
    public int getTileDimension() {
    	
        // WRITE YOUR CODE HERE
        return tileDimension;
    }

    /*
     * Returns original instance variable
     *
     * @return original
     */
    public Picture getOriginalPicture() {

        // WRITE YOUR CODE HERE
    	return original;
    }

    /*
     * Returns collage instance variable
     *
     * @return collage
     */
    public Picture getCollagePicture() {

        // WRITE YOUR CODE HERE
    	return collage;
    }
    
    /*
     * Display the original image
     * Assumes that original has been initialized
     */
    public void showOriginalPicture() {

        // WRITE YOUR CODE HERE
    	original.show();
    }

    /*
     * Display the collage image
     * Assumes that collage has been initialized
     */
    public void showCollagePicture() {

        // WRITE YOUR CODE HERE
    	collage.show();
    }

    /*
     * Replaces the tile at collageCol,collageRow with the image from filename
     * Tile (0,0) is the upper leftmost tile
     *
     * @param filename image to replace tile
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void replaceTile (String filename,  int collageCol, int collageRow) {

        // WRITE YOUR CODE HERE
    	Picture pic = new Picture(filename);
    	
    	for (int i = 0; i < tileDimension; i++)
    	{
    		for (int j = 0; j < tileDimension; j++)
    		{
    			Color color = pic.get((i * pic.width() / tileDimension), (j * pic.height() / tileDimension));
    			collage.set(i + tileDimension * collageCol, j + tileDimension * collageRow, color); 			
    		}
    	}
    }
    
    /*
     * Makes a collage of tiles from original Picture
     * original will have collageDimension x collageDimension tiles, each tile
     * has tileDimension X tileDimension pixels
     */
    public void makeCollage () {

    // WRITE YOUR CODE HERE    	
    	for (int i = 0; i < tileDimension; i++)
    	{
    		for (int j = 0; j < tileDimension; j++)
    		{
    			Color color = original.get((i * original.width() / tileDimension), (j * original.height() / tileDimension));
    			collage.set(i, j, color); 			
    		}
    	}
    	
    	Picture temp = new Picture(tileDimension * collageDimension, tileDimension * collageDimension);

    	int c = 0;
    	int r = 0;

    	for(int i = 0; i < tileDimension * collageDimension; i++) 
    	{  
    		if(i % tileDimension == 0)
            {
    			r = 0;
    		}
            
    		for(int j = 0; j < tileDimension * collageDimension; j++) 
    		{   			
    			if(j % tileDimension == 0) {
    				c = 0;
    			}
    			Color color = collage.get(c, r);
    			temp.set(j, i, color);
    			c++;
    		}
    		r++;
    	}
    	collage = temp;
    }

    /*
     * Colorizes the tile at (collageCol, collageRow) with component 
     * (see Week 9 slides, the code for color separation is at the 
     *  book's website)
     *
     * @param component is either red, blue or green
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void colorizeTile (String component,  int collageCol, int collageRow) {

    	// WRITE YOUR CODE HERE
    	if(component.equals("green"))
        {
    		for(int i = tileDimension * collageRow; i < tileDimension * collageRow + tileDimension; i++)
            {
        		for(int j = tileDimension * collageCol; j < tileDimension * collageCol + tileDimension; j++)
                {
        			int k = collage.getRGB(j,i);
                    
                    int l = (k >> 24) & 0xff;
                    int m = (k >> 8) & 0xff;
                    
                    //set new RGB
                    k = (l << 24) | (0 << 16) | (m << 8) | 0;
                    
                    collage.setRGB(j, i, k);	
        		}
        	} 			
    	}
        else if(component.equals("red"))
        {
    		for(int i = tileDimension * collageRow; i < tileDimension * collageRow + tileDimension; i++)
            {    		
        		for(int j = tileDimension * collageCol; j < tileDimension * collageCol + tileDimension; j++)
                {
        			int k = collage.getRGB(j,i);
                    
                    int l = (k >> 24) & 0xff;
                    int m = (k >> 16) & 0xff;
                    
                    //set new RGB
                    k = (l << 24) | (m << 16) | (0 << 8) | 0;
                    
                    collage.setRGB(j, i, k);        			
        		}
        	}	
    	}
    	else if(component.equals("blue"))
        {
    		for(int i = tileDimension * collageRow; i < tileDimension * collageRow + tileDimension; i++)
            {    			  
        		for(int j = tileDimension * collageCol; j < tileDimension * collageCol + tileDimension; j++)
                {
        			int k = collage.getRGB(j,i);
                    
                    int l = (k >> 24) & 0xff;
                    int m = k & 0xff;

                    k = (l << 24) | (0 << 16) | (0 << 8) | m;
                    
                    collage.setRGB(j, i, k);        			
        		}
        	}	
    	}
    }

    /*
     * Greyscale tile at (collageCol, collageRow)
     * (see Week 9 slides, the code for luminance is at the book's website)
     *
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void greyscaleTile (int collageCol, int collageRow) {

        // WRITE YOUR CODE HERE
    	for(int i = tileDimension * collageRow; i < tileDimension * collageRow + tileDimension; i++)
        {  
    		for(int j = tileDimension * collageCol; j < tileDimension * collageCol + tileDimension; j++)
            {
    			Color color = collage.get(j, i);
    			Color gray = Luminance.toGray(color);
    			collage.set(j, i, gray);	
    		}
    	}
    }

    // Test client 
    public static void main (String[] args) {
    	ArtCollage art = new ArtCollage("Ariel.jpg");
    	art.makeCollage();
    	art.colorizeTile("blue", 1, 3);
    	art.greyscaleTile(1, 0);
    	//art.replaceTile("Ariel.jpg", 1, 1);
    	art.replaceTile("Flo.jpg", 2, 1);
    	art.colorizeTile("red", 2, 1);
    	art.colorizeTile("green", 0, 2);
    	art.showCollagePicture();
    }
}
