package pract_lesson_;

public class PaintJobExercise {
    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets){
        double area = 0.0;
        double buckets = 0.0;
        if(width > 0 && height > 0 && areaPerBucket > 0 && extraBuckets >= 0){
            area = width*height;
            buckets = area/areaPerBucket;
            return (int) Math.ceil(buckets-extraBuckets);
        }

        return -1;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket){
        double area = 0.0;
        double buckets = 0.0;
        if(width > 0 && height > 0 && areaPerBucket > 0){
            area = width*height;
            buckets = area/areaPerBucket;
            return (int) Math.ceil(buckets);
        }

        return -1;
    }

    public static int getBucketCount(double area, double areaPerBucket){
        double buckets = 0.0;
        if(area > 0 && areaPerBucket > 0){
            buckets = area/areaPerBucket;;
            return (int) Math.ceil(buckets);
        }

        return -1;
    }
}
