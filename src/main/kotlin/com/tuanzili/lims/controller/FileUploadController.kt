package com.tuanzili.lims.controller

import com.jxpanda.common.base.Result
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

@Api("/file", tags = ["文件上传"])
@RestController()
@RequestMapping("/file")
class FileUploadController {

    @PostMapping("/upload")
    @Throws(IOException::class)
    fun singleFileUpload(@RequestParam("file") file: MultipartFile): Result<String> {

        if (file.isEmpty) {
          return Result.error("上传的文件为空")
        }
        saveFile(file)
        return Result.ok(file.originalFilename)
    }

    @Throws(IOException::class)
    private fun saveFile(file: MultipartFile) {
        val src = System.getProperty("user.dir")
        val path: Path = Paths.get(src + "/upload/" + file.originalFilename)
        file.transferTo(path)
    }

}
