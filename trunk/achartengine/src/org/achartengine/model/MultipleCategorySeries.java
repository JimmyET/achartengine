/**
 * Copyright (C) 2009 SC 4ViewSoft SRL
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.achartengine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A series for the multiple category charts like the doughnut.
 */
public class MultipleCategorySeries implements Serializable {
  /** The series title. */
  private String mTitle;
  
  /** The series local keys. */
  private List<String> mCategories = new ArrayList<String>();
  
  /** The series name. */
  private List<String[]> mTitles = new ArrayList<String[]>();
  
  /** The series values. */
  private List<double[]> mValues = new ArrayList<double[]>();

  /**
   * Builds a new category series.
   * @param title the series title
   */
  public MultipleCategorySeries(String title) {
    mTitle = title;
  }

  /**
   * Adds a new value to the series
   * @param titles the titles to be used as labels
   * @param values the new value
   */
  public void add(String[] titles, double[] values) {
//    checkNewValues(titles, values);
    add(mCategories.size() + "", titles, values);
  }

  /**
   * Adds a new value to the series.
   * @param category the category name
   * @param titles the titles to be used as labels
   * @param values the new value
   */
  public void add(String category, String[] titles, double[] values) {
//    checkNewValues(titles, values);
    mCategories.add(category);
    mTitles.add(titles);
    mValues.add(values);
  }
  
  /**
   * Returns the values at the specified index.
   * @param index the index
   * @return the value at the index
   */
  public double[] getValues(int index) {
    return mValues.get(index);
  }

  private void checkNewValues(String[] titles, double[] values) {
    if (titles.length != values.length) {
      throw new IllegalArgumentException("The titles and the values must have the same size");
    }
  }
  
  /**
   * Returns the category name at the specified index.
   * @param index the index
   * @return the category name at the index
   */
  public String getCategory(int index) {
    return mCategories.get(index);
  }
  
  /**
   * Returns the categories count.
   * @return the categories count
   */
  public int getCategoriesCount() {
    return mCategories.size();
  }

  /**
   * Returns the series item count.
   * @param index the index
   * @return the series item count
   */
  public int getItemCount(int index) {
    return mValues.get(index).length;
  }
  
  /**
   * Returns the series titles.
   * @param index the index
   * @return the series titles
   */
  public String[] getTitles(int index) {
    return mTitles.get(index);
  }
  
  /**
   * Transforms the category series to an XY series.
   * @return the XY series
   */
  public XYSeries toXYSeries() {
    XYSeries xySeries = new XYSeries(mTitle);
    return xySeries;
  }
}