package per.itachi.java.json.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import java.nio.charset.Charset;
import java.util.UUID;

public class BloomFilterEntry {

    public static void main(String[] args) {
        int insertions = Integer.valueOf(args[0]);
        double fpp = Double.valueOf(args[1]);
        BloomFilter<String> bloomFilter = BloomFilter
                .create(Funnels.stringFunnel(Charset.defaultCharset()), insertions, fpp);

        String value = UUID.randomUUID().toString();
        bloomFilter.put(value);
        System.out.printf("The value %s is in filter: %s %n", value, bloomFilter.mightContain(value));
    }
}
