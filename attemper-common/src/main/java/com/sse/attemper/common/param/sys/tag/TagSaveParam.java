package com.sse.attemper.common.param.sys.tag;

import com.sse.attemper.common.enums.TagType;
import com.sse.attemper.common.param.CommonParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * @author ldang
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagSaveParam implements CommonParam {

    protected String tagName;

    protected String displayName;

    protected Integer tagType;

    protected String remark;

    public String validate() {
        if(StringUtils.isBlank(tagName)) {
            return "5300";
        }
        if(StringUtils.isBlank(displayName)) {
            return "5303";
        }
        if(TagType.get(tagType) == null){
            return "5321";
        }
        return null;
    }

}